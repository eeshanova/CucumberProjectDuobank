package step_definitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.KatyaPage;
import pages.SanaPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
	
	
	
	@Before
	public void setupScenario() {
		
		Driver.getDriver().manage().timeouts().
		implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		
		
	}
	
	@After
	public static void tearDownScenario(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			scenario.attach(screenshot, "image/png", "Screenshot"+date);
		}
		
		
		
		Driver.quit();
	}
	
	
	//Method added by Sana to get to the Expense Tab without re-writing code
	//Feel free to use if needed
	public static void loginAndOpenExpenseTab () {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		
		KatyaPage page = new KatyaPage();
		SanaPage sp = new SanaPage();
		
		BrowserUtils.waitForPageToLoad(10);
		page.LogInLink.click();
		BrowserUtils.waitFor(5);
		page.emailAddressLogIn.sendKeys("teambsana@gmail.com");
		page.passwordLogIn.sendKeys("codelab99");
		page.login.click();
		BrowserUtils.waitFor(5);
		page.mortgageButton.click();
		BrowserUtils.waitFor(2);
		page.workingWithRealtor.click();
		page.workingWithLoanOfficer.click();
		
		page.estimatedPurchasePrice.sendKeys(Keys.BACK_SPACE);
		page.estimatedPurchasePrice.sendKeys("350000");
		page.downPaymentPercentage.sendKeys(Keys.BACK_SPACE);
		page.downPaymentPercentage.sendKeys("15");
		BrowserUtils.waitFor(2);
		
		sp.nextButton.click();
		
		sp.firstName.sendKeys("teamb");
		sp.lastName.sendKeys("sana");
		sp.eMail.sendKeys("teambsana@gmail.com");
		sp.dob.sendKeys("03/21/1980");
		sp.ssnField.sendKeys("145889632");
		sp.cellPhone.sendKeys("7035847412");
		
		sp.maritalStatus.click();
		Actions a = new Actions(Driver.getDriver());
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		
		BrowserUtils.waitFor(2);
	}
	

}