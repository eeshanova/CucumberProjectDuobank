package step_definitions;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KatyaPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class KatyaSignUpStepDefs {

	
	
	 @Given("The User is on the Sign Up page") public void
	 theUserIsOnTheSignUpPage() {
	 
		 Driver.getDriver().get(ConfigReader.getProperty("url"));
	 }
	 

	@When("The user add all required information")
	public void theUserAddAllRequiredInformation() {
		Faker faker = new Faker();
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		
		KatyaPage page = new KatyaPage();
		BrowserUtils.waitForPageToLoad(10);
		page.firsName.sendKeys(""+faker.random());
		page.lastName.sendKeys(""+faker.random());
		page.emailAddress.sendKeys(generatedString + "@gmail.com");
		page.password.sendKeys(""+faker.pokemon());
		BrowserUtils.waitFor(3);

	}

	@When("The user clicks on Sign Up")
	public void theUserClicksOnSignUp() {
		KatyaPage page = new KatyaPage();
		page.signUpButton.click();
		BrowserUtils.waitFor(5);

	}

	@Then("The user should receive  message {string}")
	public void theUserShouldReceiveMessage(String string) {
		KatyaPage page = new KatyaPage();
		assertTrue(page.mssg.getText().contains(string));
		if(page.mssg.getText().contains(string)) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
		}

	}
	
	@When("The user add negative information")
	public void theUserAddNegativeInformation() {
		KatyaPage page = new KatyaPage();
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		int random1=(int)(100+Math.random()*5);
		BrowserUtils.waitForPageToLoad(10);
		page.firsName.sendKeys(""+random1);
		page.lastName.sendKeys(""+random1);
		page.emailAddress.sendKeys(""+generatedString+"@" +random1);
		page.password.sendKeys(""+random1);
		BrowserUtils.waitFor(3);
	}
	
	@Then("The user should not be able to Sign Up and shoul receive error message {string}")
	public void theUserShouldNotBeAbleToSignUpAndShoulReceiveErrorMessage(String string) {
		KatyaPage page = new KatyaPage();
		assertTrue(!page.mssg.getText().contains(string));
		if(page.mssg.getText().contains(string)) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
		}
	}
	
	@When("The user add russ. language information")
	public void theUserAddRussLanguageInformation() {
		KatyaPage page = new KatyaPage();
		int random1=(int)(100+Math.random()*5);
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String russString = "russrussrussruss";
		BrowserUtils.waitForPageToLoad(10);
		page.firsName.sendKeys(""+russString);
		page.lastName.sendKeys(""+random1+russString);
		page.emailAddress.sendKeys(""+generatedString+"@" +random1);
		page.password.sendKeys(""+russString);
		BrowserUtils.waitFor(3);
	}





}
