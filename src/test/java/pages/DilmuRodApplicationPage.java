package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DilmuRodApplicationPage {

	public DilmuRodApplicationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='mortagage.php']")
	public WebElement application;

	@FindBy(xpath = "(//span[@class='icon-title'])[1]")
	public WebElement preApproval;

	@FindBy(xpath = "//a[@href='#next']")
	public WebElement nextButton;
	
	@FindBy(id = "realtorinfo")
	public WebElement realtor;
	
	@FindBy(id = "estimatedprice")
	public WebElement estPrice;
	
	@FindBy(id = "downpaymentpercentage")
	public WebElement downPayment;
	
	@FindBy(xpath = "(//span[@class='icon-title'])[2]")
	public WebElement personalInfo;

	@FindBy(id = "b_firstName")
	public WebElement firstName;

	@FindBy(id = "b_lastName")
	public WebElement lastName;

	@FindBy(id = "b_email")
	public WebElement email;

	@FindBy(id = "b_ssn")
	public WebElement ssn;

	@FindBy(xpath = "//*[@id=\"b_marital\"]/option[2]")
	public WebElement married;

	@FindBy(id = "b_cell")
	public WebElement cellPhone;

	@FindBy(xpath = "(//span[@class='icon-title'])[3]")
	public WebElement expenses;

	@FindBy(id = "monthlyrentalpayment")
	public WebElement monthlyRental;

	@FindBy(xpath = "(//span[@class='icon-title'])[4]")
	public WebElement employment;
	
	@FindBy(id = "employername1")
	public WebElement employerName; //Rod
	
	@FindBy(id = "position1")
	public WebElement position; //Rod
	
	
	@FindBy(xpath = "(//span[@class='icon-title'])[5]")
	public WebElement credit;//Rod
	
	@FindBy(id = "creditreport1")
	public WebElement yesCheckBoxCredit; //Rod
	
	@FindBy(id = "creditreport2")
	public WebElement noCheckBoxCredit; //Rod
	
	@FindBy(xpath = "(//span[@class='icon-title'])[6]")
	public WebElement econsent;//Rod
	
	@FindBy(xpath = "//label[@id='eConsentdeclarerFirstName-error']")
	public WebElement fieldReqNameMsg; //Rod
	
	@FindBy(id = "eConsentdeclarerLastName-error")
	public WebElement fieldReqLastNameMsg; //Rod
	
	@FindBy(id = "eConsentdeclarerEmail-error")
	public WebElement fieldReqEmailMsg; //Rod
	
	@FindBy(id = "consentagree-error")
	public WebElement fieldReqAgreeMsg; //Rod
	
	
}
