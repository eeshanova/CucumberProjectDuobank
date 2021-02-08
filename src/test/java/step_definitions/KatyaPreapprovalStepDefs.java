package step_definitions;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KatyaPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class KatyaPreapprovalStepDefs {

	
	@Given("The User is on the Sign in page")
	public void theUserIsOnTheSignInPage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));

	}

	@When("The user land on Accound page")
	public void theUserLandOnAccoundPage() {
		KatyaPage page = new KatyaPage();
		BrowserUtils.waitForPageToLoad(10);
		page.LogInLink.click();
		page.emailAddressLogIn.sendKeys("katya@test");
		page.passwordLogIn.sendKeys("test");
		page.login.click();
		BrowserUtils.waitFor(1);
	}

	@Then("The name of acount nedd to be {string}")
	public void theNameOfAcountNeddToBe(String string) {
		KatyaPage page = new KatyaPage();
		assertTrue(page.userName.getText().contains(string));
		
	
	}
	
	
	
	@Given("The User is on the preapproval details tab")
	public void theUserIsOnThePreapprovalDetailsTab() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		
		KatyaPage page = new KatyaPage();
		BrowserUtils.waitForPageToLoad(10);
		page.LogInLink.click();
		page.emailAddressLogIn.sendKeys("katya@test");
		page.passwordLogIn.sendKeys("test");
		page.login.click();
		
		BrowserUtils.waitFor(5);
		
		
		
		try {
			Alert alert2 = Driver.getDriver().switchTo().alert();
			alert2.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("No Password Alert was displayed");
		}
		
		BrowserUtils.waitFor(5);
		page.mortgageButton.click();
		BrowserUtils.waitFor(5);
	}

	@When("The users click on all needed checkboxes")
	public void theUsersClickOnAllNeededCheckboxes() {
		KatyaPage page = new KatyaPage();
		page.workingWithRealtor.click();
		page.workingWithLoanOfficer.click();
	}

	@When("The user enters {string} , {string}")
	public void theUserEnters(String string, String string2) {
		KatyaPage page = new KatyaPage();
		page.estimatedPurchasePrice.sendKeys(Keys.BACK_SPACE);
		page.estimatedPurchasePrice.sendKeys(string);
		page.downPaymentPercentage.sendKeys(Keys.BACK_SPACE);
		page.downPaymentPercentage.sendKeys(string2);
		//BrowserUtils.waitFor(3);
	}

	@Then("The user should be able to click on Next Button")
	public void theUserShouldBeAbleToClickOnNextButton() {
		KatyaPage page = new KatyaPage();
		page.nextButton.click();
		BrowserUtils.waitFor(1);
		assertTrue(page.personalInfo.getText().contains("Personal Information"));
		if(page.personalInfo.getText().contains("Personal Information")) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
		}

	}
	
	@When("Then user change ESTIMATED PURCHASE PRICE to negative information")
	public void thenUserChangeESTIMATEDPURCHASEPRICEToNegativeInformation() {
		KatyaPage page = new KatyaPage();
		page.estimatedPurchasePrice.sendKeys(Keys.BACK_SPACE);
		page.estimatedPurchasePrice.sendKeys(Keys.BACK_SPACE);
		page.estimatedPurchasePrice.sendKeys(Keys.BACK_SPACE);
		//page.estimatedPurchasePrice.sendKeys("1");
	}

	@Then("The user should be not able to click on Next Button")
	public void theUserShouldBeNotAbleToClickOnNextButton() {
		KatyaPage page = new KatyaPage();
		page.nextButton.click();
		BrowserUtils.waitFor(1);
		assertTrue(page.personalInfo.getText().contains("Personal Information"));
		if(page.personalInfo.getText().contains("Personal Information")) {
			System.out.println("FAILED");
		}else {
			System.out.println("PASSED");
		}

	
	}
	 


}
