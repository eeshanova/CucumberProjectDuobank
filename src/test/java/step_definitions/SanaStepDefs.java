package step_definitions;


import static org.junit.Assert.assertTrue;

import java.awt.datatransfer.Clipboard;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KatyaPage;
import pages.SanaPage;
import pojos.UserInfo;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class SanaStepDefs {
	
	
	@Given("The user logs in their account and fills out the Preapproval Details")
	public void theUserLogsInTheirAccountAndFillsOutThePreapprovalDetails() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		
		KatyaPage page = new KatyaPage();
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

		
	}
	

	@When("The user lands on Personal Information Tab")
	public void theUserLandsOnPersonalInformationTab() {
	    SanaPage sp = new SanaPage();
	    
	    sp.personalInfoTab.click();
	    
	}

	@Then("The user checks the Co-Borrower box")
	public void theUserChecksTheCoBorrowerBox() {
		SanaPage sp = new SanaPage();
		
		sp.coBorrowerBox.click();
		BrowserUtils.scroll(0, 50);
		
	}

	@Then("The Co-Borrower input form appears")
	public void theCoBorrowerInputFormAppears() {
		SanaPage sp = new SanaPage();
		
		String str = sp.coBorrowerTitle.getText();
		assertTrue(str.contains("Co-Borrower's Information"));
		
	}
	
	
////////// TC - 2 ///////////////////
	
	
	@Then("The user skips all required input box and clicks next")
	public void theUserSkipsAllRequiredInputBoxAndClicksNext() {
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys("teamb");
		sp.nextButton.click();
	
	}

	@Then("The error message is displayed")
	public void theErrorMessageIsDisplayed() {
		SanaPage sp = new SanaPage();
		
		String str = sp.lastNameError.getText();
		assertTrue(str.contains("THIS FIELD IS REQUIRED"));


	}
	
	
	
//////////TC - 3 ///////////////////
	
	
	@Then("The user enters the following info and enters future DOB")
	public void theUserEntersTheFollowingInfoAndEntersFutureDOB(List<UserInfo> dataTable) {
	    
		UserInfo user = dataTable.get(0);
		
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys(user.getFirst());
		sp.lastName.sendKeys(user.getLast());
		sp.eMail.sendKeys(user.getEmail());
		sp.dob.sendKeys(user.getDateOfBirth());
		sp.ssnField.sendKeys(user.getsSN());
		sp.cellPhone.sendKeys(user.getCellPhone());
		
		sp.maritalStatus.click();
		Actions a = new Actions(Driver.getDriver());
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		
		sp.nextButton.click();
		
		
	}

	@Then("The error message is displayed to enter correct DOB")
	public void theErrorMessageIsDisplayedToEnterCorrectDOB() {

		SanaPage sp = new SanaPage();
		
		sp.personalInfoTab.click();
		
		String str = sp.personalInfoTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));

	}
	
	
	
//////////TC - 4 ///////////////////
	
	
	
	@Then("The user enters the following info and enters invalid SSN")
	public void theUserEntersTheFollowingInfoAndEntersInvalidSSN(List<UserInfo> dataTable) {

		UserInfo user = dataTable.get(0);
		Actions a = new Actions(Driver.getDriver());
		
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys(user.getFirst());
		sp.lastName.sendKeys(user.getLast());
		sp.eMail.sendKeys(user.getEmail());
		sp.dob.sendKeys(user.getDateOfBirth());
		sp.ssnField.click();
		String s = Keys.chord(Keys.CONTROL, "v");
		sp.ssnField.sendKeys(s);
		
		sp.cellPhone.sendKeys(user.getCellPhone());
		
		sp.maritalStatus.click();
		
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		
		sp.nextButton.click();
		
	}

	@Then("The error message is displayed to enter valid SSN")
	public void theErrorMessageIsDisplayedToEnterValidSSN() {
		SanaPage sp = new SanaPage();
		
		sp.personalInfoTab.click();
		
		String str = sp.personalInfoTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));
	}
	
	
	
//////////TC - 5 ///////////////////
	
	@Then("The user enters the following info and enters invalid name")
	public void theUserEntersTheFollowingInfoAndEntersInvalidName(List<UserInfo> dataTable) {
		
		UserInfo user = dataTable.get(0);
		
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys(user.getFirst());
		sp.lastName.sendKeys(user.getLast());
		sp.eMail.sendKeys(user.getEmail());
		sp.dob.sendKeys(user.getDateOfBirth());
		sp.ssnField.sendKeys(user.getsSN());
		sp.cellPhone.sendKeys(user.getCellPhone());
		
		sp.maritalStatus.click();
		Actions a = new Actions(Driver.getDriver());
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		
		sp.nextButton.click();
		
	}

	@Then("The error message is displayed to enter valid name")
	public void theErrorMessageIsDisplayedToEnterValidName() {
		SanaPage sp = new SanaPage();
		
		sp.personalInfoTab.click();
		
		String str = sp.personalInfoTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));
	}
	
	
	
//////////TC - 6 ///////////////////
	
	
	@Then("The user enters the following info and enters invalid cellphone number")
	public void theUserEntersTheFollowingInfoAndEntersInvalidCellphoneNumber(List<UserInfo> dataTable) {
		
		UserInfo user = dataTable.get(0);
		
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys(user.getFirst());
		sp.lastName.sendKeys(user.getLast());
		sp.eMail.sendKeys(user.getEmail());
		sp.dob.sendKeys(user.getDateOfBirth());
		sp.ssnField.sendKeys(user.getsSN());
	
		String s = Keys.chord(Keys.CONTROL, "v");
		sp.cellPhone.sendKeys(s);
		
		sp.maritalStatus.click();
		Actions a = new Actions(Driver.getDriver());
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		
		sp.nextButton.click();

	}

	@Then("The error message is displayed to enter valid cellphone number")
	public void theErrorMessageIsDisplayedToEnterValidCellphoneNumber() {
		SanaPage sp = new SanaPage();
		
		sp.personalInfoTab.click();
		
		String str = sp.personalInfoTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));
	}
	
	
////////// TC - 7 ///////////////////
	
	
	
	@Then("The user correctly enters the required info and unchecks the policy button")
	public void theUserCorrectlyEntersTheRequiredInfoAndUnchecksThePolicyButton() {
		
		SanaPage sp = new SanaPage();
		
		sp.firstName.sendKeys("teamb");
		sp.lastName.sendKeys("sana");
		sp.eMail.sendKeys("teambsana@gmail.com");
		sp.dob.sendKeys("03/21/1980");
		sp.ssnField.sendKeys("145889632");
		sp.cellPhone.sendKeys("7035847412");
		
		sp.maritalStatus.click();
		Actions a = new Actions(Driver.getDriver());
		a.sendKeys("" + Keys.DOWN + Keys.ENTER).build().perform();
		

		if(!sp.policyCheckBox.isSelected()) {
			sp.policyCheckBox.click();
				}
		
		sp.nextButton.click();
		
		
		
	}

	@Then("error message is dispalyed instructing the user to accept the policy")
	public void errorMessageIsDispalyedInstructingTheUserToAcceptThePolicy() {
		SanaPage sp = new SanaPage();
		
		sp.personalInfoTab.click();
		
		String str = sp.personalInfoTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));

		
	}
	
	
//////////TC - 8 ///////////////////
	
	
	
	@Then("The user click on the Privacy Policy link")
	public void theUserClickOnThePrivacyPolicyLink() {
		SanaPage sp = new SanaPage();
		
		sp.policyLink.click();
		
//		String parentWindowHandle = Driver.getDriver().getWindowHandle();
//
//		Set<String> windowHandles = Driver.getDriver().getWindowHandles();

//		for (String handle : windowHandles) {
//			if(!handle.equals(parentWindowHandle)) {
//				Driver.getDriver().switchTo().window(handle);
//			} }
		
		
	}

	@Then("The user is directed to the correct Privacy Policy webpage")
	public void theUserIsDirectedToTheCorrectPrivacyPolicyWebpage() {
		SanaPage sp = new SanaPage();
		
		String str = Driver.getDriver().getTitle();
		
		assertTrue(str.equalsIgnoreCase("Privacy Policy"));

	}
	
	
//////////TC - 9 ///////////////////
	
	
	@Given("The user logs in their account and fills out the first two tabs")
	public void theUserLogsInTheirAccountAndFillsOutTheFirstTwoTabs() {

		Hooks.loginAndOpenExpenseTab();
		BrowserUtils.waitFor(5);
		
	}

	@When("The user lands on Expenses Tab")
	public void theUserLandsOnExpensesTab() {
		
		SanaPage sp = new SanaPage();
		sp.nextButton.click();
		
	}

	@Then("The user clicks on the own check box")
	public void theUserClicksOnTheOwnCheckBox() {
		SanaPage sp = new SanaPage();
		
		sp.ownCheckBox.click();
		sp.mortagePayment.sendKeys("2500");
		
	}

	@Then("The user can enter the correct payment amount")
	public void theUserCanEnterTheCorrectPaymentAmount() {
		SanaPage sp = new SanaPage();
		
		sp.nextButton.click();
		
		sp.expenseTab.click();
		
		String str = sp.expenseTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(noError));
		
		
	}
	
	
	/////////// TC - 10  ////////////

	@Then("The user clicks on the rent check box and enters invalid payment")
	public void theUserClicksOnTheRentCheckBoxAndEntersInvalidPayment() {
		SanaPage sp = new SanaPage();
		
		sp.rentCheckBox.click();
		
		String s = Keys.chord(Keys.CONTROL, "v");
		sp.rentPayment.sendKeys(s);
		
	}

	@Then("error message is dispalyed instructing the user to enter valid payment")
	public void errorMessageIsDispalyedInstructingTheUserToEnterValidPayment() {
		SanaPage sp = new SanaPage();
		
		sp.nextButton.click();
		
		sp.expenseTab.click();
		
		sp.nextButton.click();
		
		String str = sp.expenseTab.getCssValue("color");
		
		String errorMessage = "rgba(255, 91, 92, 1)";
		String noError = "rgba(90, 141, 238, 1)";
		
		assertTrue(str.equalsIgnoreCase(errorMessage));
		
	}

	
	
	

}
