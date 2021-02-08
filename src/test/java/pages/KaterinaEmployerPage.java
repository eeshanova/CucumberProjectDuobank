package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class KaterinaEmployerPage {

	public KaterinaEmployerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id="employername1")
	public WebElement employer;
	
	@FindBy (id="position1")
	public WebElement position;
	
	@FindBy (id="city")
	public WebElement city;
	
	@FindBy (id="state1")
	public WebElement state;
	
	@FindBy (xpath="//select[@id='state1']/option")
	public List<WebElement> stateValue;
	
	@FindBy (id="start_date1")
	public WebElement startDate;
	
	@FindBy (id="grossmonthlyincome")
	public WebElement monthlyIncome;
	
	@FindBy (xpath = "(//span[@class='icon-title'])[5]")
	public WebElement credit;
	
	@FindBy (xpath = "//select[@id='incomesource1']/option")
	public List<WebElement> incomeSource1;
	
	@FindBy (xpath = "//select[@id='incomesource2']/option")
	public List<WebElement> incomeSource2;
	
	@FindBy (xpath = "//select[@id='incomesource3']/option")
	public List<WebElement> incomeSource3;
	
	@FindBy (id = "addemployer")
	public WebElement addEmployer;
	
	@FindBy (id="employername2")
	public WebElement employer2;
	
	@FindBy (id="position2")
	public WebElement position2;
	
	@FindBy (id="city2")
	public WebElement city2;
	
	@FindBy (id="start_date2")
	public WebElement startDate2;

	@FindBy (id="clear2")
	public WebElement clearButton2;
	
	@FindBy (id="remove2")
	public WebElement removeButton2;
	
	@FindBy (xpath = "//*[@role='dialog']")
	public WebElement removeBox;

	@FindBy (xpath = "//button[@class='swal2-confirm btn btn-warning']")
	public WebElement yesButton;

	@FindBy (id ="end_date2")
	public WebElement endDate2;

	@FindBy (id="monthlyovertime")
	public WebElement monthlyOvertime;

	@FindBy (id="monthlybonuses")
	public WebElement monthlyBonus;

	@FindBy (id="monthlycommission")
	public WebElement monthlyComm;

	@FindBy (id="monthlydividents")
	public WebElement monthlyDiv;

	@FindBy (id="amount1")
	public WebElement amount;
	
	
	
	
	

}
