package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SanaPage {
	
	public SanaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	
	@FindBy (xpath = "(//span[@class='d-block'])[2]")
	public WebElement personalInfoTab;
	
	
	@FindBy (xpath = "//label[@for='coborrower1']")
	public WebElement coBorrowerBox;


	@FindBy (xpath = "//div[@class='co-borrower']//h6")
	public WebElement coBorrowerTitle;
	
	
	@FindBy (xpath = "//a[@href='#next']")
	public WebElement nextButton;
	

	@FindBy (xpath = "//input[@ID='b_firstName']")
	public WebElement firstName;
	
	@FindBy (xpath = "//label[@id='b_lastName-error']")
	public WebElement lastNameError;
	
	@FindBy (id = "select2-b_marital-container")
	public WebElement maritalStatus;
	
	@FindBy (id = "b_lastName")
	public WebElement lastName;
	
	@FindBy (id = "b_email")
	public WebElement eMail;
	
	@FindBy (id = "b_dob")
	public WebElement dob;
	
	@FindBy (id = "b_ssn")
	public WebElement ssnField;
	
	@FindBy (id = "b_cell")
	public WebElement cellPhone;
	
	@FindBy (xpath = "//label[@for='privacypolicy']")
	public WebElement policyCheckBox;
	
	@FindBy (xpath = "//a[@href='privacypolicy.html']")
	public WebElement policyLink;
	
	@FindBy (xpath = "//label[@for='expense2']")
	public WebElement ownCheckBox;
	
	@FindBy (xpath = "//label[@for='expense1']")
	public WebElement rentCheckBox;
	
	@FindBy (xpath = "(//h6[@class='py-50'])[4]")
	public WebElement expenseTitle;
	
	@FindBy (id = "firtmortagagetotalpayment")
	public WebElement mortagePayment;
	
	@FindBy (xpath = "(//span[@class='d-block'])[3]")
	public WebElement expenseTab;
	
	@FindBy (id = "monthlyrentalpayment")
	public WebElement rentPayment;
	
	
	
	
}
