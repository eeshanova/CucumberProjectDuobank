package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class KatyaPage {
	
	public KatyaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
//***********************SIGN UP*******************************************************	

	@FindBy (xpath = "//input[@id='inputfirstname4']")
	public WebElement firsName;
	
	@FindBy (xpath = "//input[@id='inputlastname4']")
	public WebElement lastName;
	
	@FindBy (xpath = "//input[@id='email']")
	public WebElement emailAddress;
	
	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	public WebElement password;
	
	@FindBy (xpath = "//button[@id='register']")
	public WebElement signUpButton;
	
	@FindBy (xpath = "//h4[@class='text-center mb-2']")
	public WebElement mssg;

//***********************SIGN IN*******************************************************	
	
	@FindBy (xpath = "//div[@class='text-center']//a")
	public WebElement LogInLink;
	
	@FindBy (xpath = "//input[@id='exampleInputEmail1']")
	public WebElement emailAddressLogIn;
	
	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	public WebElement passwordLogIn;
	
	@FindBy (xpath = "//button[@class='btn btn-primary glow w-100 position-relative']")
	public WebElement login;
	
	@FindBy (xpath = "//span[@class='user-name']")
	public WebElement userName;
	
	@FindBy (xpath = "//span[@class='menu-item'][contains(text(),'Mortgage Application')]")
	public WebElement mortgageButton;
	
//***********************PreApproval Details*******************************************	
	
	@FindBy (xpath = "//label[@for='realtor2']")
	public WebElement workingWithRealtor;
	
	@FindBy (xpath = "//label[@for='loanofficer2']")
	public WebElement workingWithLoanOfficer;
	
	@FindBy (xpath = "//input[@id='estimatedprice']")
	public WebElement estimatedPurchasePrice;
	
	@FindBy (xpath = "//input[@id='downpaymentpercentage']")
	public WebElement downPaymentPercentage;
	
	@FindBy (xpath = "//a[@class='btn btn-light-primary'][contains(text(),'Next')]")
	public WebElement nextButton;
	
	@FindBy (xpath = "//h6[@class='py-50'][contains(text(),'Personal Information')]")
	public WebElement personalInfo;
	
	
	
	
	
	
	
	
	
}
