package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Button;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DilmuRodApplicationPage;
import pages.DilmuRodLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class DilmuRodStepDefs {

	@Given("The User is on the homepage")
	public void theUserIsOnTheHomepage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	}

	@When("The user inputs {string} for email address and {string} for password")
	public void theUserInputsForEmailAddressAndForPassword(String email, String password) {
		DilmuRodLoginPage lp = new DilmuRodLoginPage();
		lp.email.sendKeys(email);
		// BrowserUtils.waitFor(5);
		lp.password.sendKeys(password);
		// BrowserUtils.waitFor(5);
	}

	@Then("The user clicks on login button")
	public void theUserClicksOnLoginButton() {
		new DilmuRodLoginPage().loginButton.click();

	}

	@When("The user clicks on Mortgage Application and lands on {string} tab")
	public void theUserClicksOnMortgageApplicationAndLandsOnTab(String expectedResult) {

		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.application.click();
		String actualResult = ap.preApproval.getText();
		assertEquals(expectedResult, actualResult);

	}

	@When("The user enters preapproval details info, clicks on Next button and lands on {string} tab")
	public void theUserEntersPreapprovalDetailsInfoClicksOnNextButtonAndLandsOnTab(String expectedResult) {
		Faker fake = new Faker();
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.realtor.sendKeys(fake.name().fullName());
		ap.estPrice.sendKeys(String.valueOf((fake.number().numberBetween(25000, 1000000))));
		// BrowserUtils.waitFor(5);
		ap.downPayment.sendKeys(Keys.BACK_SPACE);
		ap.downPayment.sendKeys(String.valueOf((fake.number().numberBetween(0, 100))));
		// BrowserUtils.waitFor(5);
		ap.nextButton.click();
		// BrowserUtils.waitFor(5);
		String actualResult = ap.personalInfo.getText();
		assertEquals(expectedResult, actualResult);
	}

	@When("The user enters personal info, clicks on Next button and lands on {string} tab")
	public void theUserEntersPersonalInfoClicksOnNextButtonAndLandsOnTab(String expectedResult) {
		Faker fake = new Faker();
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.firstName.sendKeys(fake.name().firstName());
		ap.lastName.sendKeys(fake.name().lastName());
		ap.email.sendKeys(fake.internet().emailAddress());
		ap.ssn.sendKeys(fake.number().numberBetween(0, 999) + "-" + fake.number().numberBetween(0, 99) + "-"
				+ fake.number().numberBetween(0, 999));
		// BrowserUtils.waitFor(5);
		Select maritalStatus = new Select(Driver.getDriver().findElement(By.id("b_marital")));
		maritalStatus.selectByValue("Married");
//		BrowserUtils.hover(ap.married);
//		ap.married.click();
		ap.cellPhone.sendKeys(String.valueOf(fake.phoneNumber()));
		// BrowserUtils.waitFor(5);
		ap.nextButton.click();
		// BrowserUtils.waitFor(5);
		String actualResult = ap.expenses.getText();
		assertEquals(expectedResult, actualResult);
	}

	@When("The user enters expenses info, clicks on Next button and lands on {string} tab")
	public void theUserEntersExpensesInfoClicksOnNextButtonAndLandsOnTab(String expectedResult) {
		Faker fake = new Faker();
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.monthlyRental.sendKeys(String.valueOf(fake.number().randomDouble(2, 300, 5000)));
		// BrowserUtils.waitFor(5);
		ap.nextButton.click();
		String actualResult = ap.employment.getText();
		assertEquals(expectedResult, actualResult);
	}

	@When("The user enters employment info and clicks on Next button")
	public void theUserEntersEmploymentInfoAndClicksOnNextButton() {
		Faker fake = new Faker();
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();

		ap.employerName.sendKeys(String.valueOf(fake.company().name()));
		// BrowserUtils.waitFor(5);
		ap.position.sendKeys(String.valueOf(fake.company().profession()));
		ap.nextButton.click();

	}

	@Then("The user lands on {string} tab")
	public void theUserLandsOnTab(String expectedResult) {
		// BrowserUtils.waitFor(5);
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		String actualResult = ap.credit.getText();
		assertTrue(actualResult.contains(expectedResult));

	}

	@When("user clicks on NO option for order credit report and clicks on NEXT button")
	public void userClicksOnNOOptionForOrderCreditReportAndClicksOnNEXTButton() {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		BrowserUtils.jsClick(ap.noCheckBoxCredit);
		// ap.noCheckBoxCredit.click();
		BrowserUtils.waitFor(5);
		ap.nextButton.click();

	}

	@When("The user is on CREDIT REPORT tab")
	public void theUserIsOnCREDITREPORTTab() {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.credit.click();

	}

	@Then("The user clicks on YES option for credit report and clicks on NEXT button")
	public void theUserClicksOnYESOptionForCreditReportAndClicksOnNEXTButton() {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		if (!(ap.yesCheckBoxCredit).isSelected()) {
			BrowserUtils.jsClick(ap.yesCheckBoxCredit);
		}
		BrowserUtils.waitFor(5);
		ap.nextButton.click();
	}

	@Then("The user lands on ECONSENT tab")
	public void theUserLandsOnECONSENTTab() {

		String expectedResult = "ECONSENT";
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		String actualResult = ap.econsent.getText();
		BrowserUtils.waitFor(5);
		assertTrue(actualResult.contains("ECONSENT"));

	}

	@When("The user is on ECONSENT tab")
	public void theUserIsOnECONSENTTab() {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		String actualResult = ap.econsent.getText();
	}

	@Then("The user leaves required fields blank and clicks on NEXT button")
	public void theUserLeavesRequiredFieldsBlankAndClicksOnNEXTButton() {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		ap.nextButton.click();
		BrowserUtils.waitFor(5);
	 
	}

	@Then("The user sees the {string} are empty and displaying appropriate message;")
	public void theUserSeesTheAreEmptyAndDisplayingAppropriateMessage(String expectedResult) {
		DilmuRodApplicationPage ap = new DilmuRodApplicationPage();
		
//		for (int i = 0; i < array.length; i++) {
//			
//		}
		String actualResult = ap.fieldReqNameMsg.getText();
		System.out.println(actualResult);
		assertEquals(expectedResult, actualResult);
		
		 
	}
}
