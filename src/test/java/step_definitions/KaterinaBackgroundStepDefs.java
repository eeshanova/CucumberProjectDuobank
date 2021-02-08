package step_definitions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KaterinaApplicationPage;
import pages.KaterinaLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class KaterinaBackgroundStepDefs {
	
	@Given("The User is on the homepage")
	public void theUserIsOnTheHomepage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	}

	@When("The user inputs {string} for email address and {string} for password")
	public void theUserInputsForEmailAddressAndForPassword(String email, String password) {
		KaterinaLoginPage lp = new KaterinaLoginPage();
		lp.email.sendKeys(email);
//		BrowserUtils.waitFor(5);
		lp.password.sendKeys(password);
//		BrowserUtils.waitFor(5);
	}

	@Then("The user clicks on login button")
	public void theUserClicksOnLoginButton() {
		new KaterinaLoginPage().loginButton.click(); 
			   
	}

	@When("The user clicks on Mortgage Application and lands on {string} tab")
	public void theUserClicksOnMortgageApplicationAndLandsOnTab(String expectedResult) {
		
		KaterinaApplicationPage ap = new KaterinaApplicationPage();
		ap.application.click();
		String actualResult = ap.preApproval.getText();
		assertEquals(expectedResult, actualResult);
	    
	}

	@When("The user enters preapproval details info, clicks on Next button and lands on {string} tab")
	public void theUserEntersPreapprovalDetailsInfoClicksOnNextButtonAndLandsOnTab(String expectedResult) {
		Faker fake = new Faker();
		KaterinaApplicationPage ap = new KaterinaApplicationPage();
		ap.realtor.sendKeys(fake.name().fullName());
		ap.estPrice.sendKeys(String.valueOf((fake.number().numberBetween(25000, 1000000))));
//		BrowserUtils.waitFor(5);
		ap.downPayment.sendKeys(Keys.BACK_SPACE);
		ap.downPayment.sendKeys(String.valueOf((fake.number().numberBetween(0, 100))));
//		BrowserUtils.waitFor(5);
		ap.nextButton.click();
//		BrowserUtils.waitFor(5);
		String actualResult = ap.personalInfo.getText();
		assertEquals(expectedResult, actualResult);
	}

	@When("The user enters personal info, clicks on Next button and lands on {string} tab")
	public void theUserEntersPersonalInfoClicksOnNextButtonAndLandsOnTab(String expectedResult) {
		Faker fake = new Faker();
		KaterinaApplicationPage ap = new KaterinaApplicationPage();
		ap.firstName.sendKeys(fake.name().firstName());
		ap.lastName.sendKeys(fake.name().lastName());
		ap.email.sendKeys(fake.internet().emailAddress());
		ap.ssn.sendKeys(fake.number().numberBetween(0, 999) +"-"+ fake.number().numberBetween(0, 99) +"-"+ fake.number().numberBetween(0, 999));
//		BrowserUtils.waitFor(5);
		Select maritalStatus = new Select(Driver.getDriver().findElement(By.id("b_marital")));
		maritalStatus.selectByValue("Married");
		ap.cellPhone.sendKeys(String.valueOf(fake.phoneNumber()));
//		BrowserUtils.waitFor(5);
		ap.nextButton.click();
//		BrowserUtils.waitFor(5);
		String actualResult = ap.expenses.getText();
		assertEquals(expectedResult, actualResult);
	}

	@When("The user enters expenses info and clicks on Next button")
	public void theUserEntersExpensesInfoAndClicksOnNextButton() {
		Faker fake = new Faker();
		KaterinaApplicationPage ap = new KaterinaApplicationPage();
		ap.monthlyRental.sendKeys(String.valueOf(fake.number().randomDouble(2, 300, 5000)));
//		BrowserUtils.waitFor(5);
		ap.nextButton.click();
	}


	@Then("The user lands on {string} tab")
	public void theUserLandsOnTab(String expectedResult) {
//		BrowserUtils.waitFor(5);
		KaterinaApplicationPage ap = new KaterinaApplicationPage();
		String actualResult = ap.employment.getText();
		assertEquals(expectedResult, actualResult);
	   
	}


}
