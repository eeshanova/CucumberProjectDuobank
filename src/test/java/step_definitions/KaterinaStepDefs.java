package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KaterinaApplicationPage;
import pages.KaterinaEmployerPage;
import pojos.EmployerKaterina;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ExcelUtils;

public class KaterinaStepDefs {
	
	@When("the user inputs the following data and clicks on Next button")
	public void theUserInputsTheFollowingDataAndClicksOnNextButton(List<EmployerKaterina> dataTable) {
//		EmployerKaterina employer = dataTable.get(0);
		KaterinaEmployerPage ep = new KaterinaEmployerPage();
		
		for (EmployerKaterina employer : dataTable) {
		
		ep.employer.sendKeys(employer.getEmployer());
		ep.position.sendKeys(employer.getPosition());
		ep.city.sendKeys(employer.getCity());
//		ep.state.sendKeys(employer.getState());
//		ep.startDate.sendKeys(employer.getStartDate());
		ep.monthlyIncome.sendKeys(employer.getMonthlyIncome());
		BrowserUtils.waitFor(5);
		new KaterinaApplicationPage().nextButton.click();
	    
	}
	}
	
	@Then("The user lands on Credit Report tab")
	public void theUserLandsOnCreditReportTab() {
		BrowserUtils.waitFor(5);
		KaterinaEmployerPage ep = new KaterinaEmployerPage();
		String expectedResult = "CREDIT REPORT";
		String actualResult = ep.credit.getText();
		assertTrue(expectedResult.contains(actualResult));
	  
	}

	
	@Then("The list of dropdown values for state should be the same as in Excel file")
	public void theListOfStatesShouldBeTheSameAsInExcelFile() {
		KaterinaEmployerPage ep = new KaterinaEmployerPage();
		
			ExcelUtils sheet = new ExcelUtils("src/test/resources/testData/employer.xlsx", "states");
			List<Map<String, String>> dataAsMap = sheet.getDataAsMap();
			
			Select select = new Select(ep.state);  

	        List<WebElement> options = select.getOptions();  
	        for(WebElement we:options)  
	        {  
	        	for (int i = 0; i < dataAsMap.size(); i++) {
	        	
	        		Map<String, String> map = dataAsMap.get(i);
	        	
	             if (we.getText().equals(map.get("State"))){
	            	 sheet.setCellData("YES", "State Displayed?", i+1);
	             } 
	
				}
	        }
	}
		
		

	@Then("The list of dropdown values for income source should be the following")
	public void theListOfDropdownValuesForIncomeSourceShouldBeTheFollowing(List<String> expectedIncome) {
		
		KaterinaEmployerPage ep = new KaterinaEmployerPage();
		List<WebElement> elems1 = ep.incomeSource1;
		List<String> actualIncome1 = new ArrayList<>();
		for (WebElement el : elems1) {
			if(!el.getAttribute("value").isEmpty()) {
				actualIncome1.add(el.getText());
			}
			}
		
        for (int i = 0; i<actualIncome1.size(); i++) {
        	
        	try {
			assertTrue(expectedIncome.get(i).contains(actualIncome1.get(i)));
        	}
        	catch (AssertionError e) {
        		System.err.println("Expected list of Income Source 1: " + expectedIncome + "\n" +
        							"Actual list of Income Source 1: " + actualIncome1);
        		throw e;
        	}
		}
        
//        List<WebElement> elems2 = ep.incomeSource2;
//		List<String> actualIncome2 = new ArrayList<>();
//		for (WebElement el : elems2) {
//			if(!el.getAttribute("value").isEmpty()) {
//				actualIncome2.add(el.getText());
//			}
//			}
//		
//        for (int i = 0; i<actualIncome2.size(); i++) {
//        	
//        	try {
//			assertTrue(expectedIncome.get(i).toLowerCase().contains(actualIncome2.get(i).toLowerCase()));
//        	}
//        	catch (AssertionError e) {
//        		System.err.println("Expected list of Income Source 2: " + expectedIncome.get(i) + "\n" +
//        							"Actual list of Income Source 2: " + actualIncome2);
//        		throw e;
//        	}
//		}
//        
//        List<WebElement> elems3 = ep.incomeSource3;
//		List<String> actualIncome3 = new ArrayList<>();
//		for (WebElement el : elems3) {
//			if(!el.getAttribute("value").isEmpty()) {
//				actualIncome3.add(el.getText());
//			}
//			}
//		
//        for (int i = 0; i<actualIncome3.size(); i++) {
//        	
//        	try {
//			assertTrue(expectedIncome.get(i).toLowerCase().contains(actualIncome3.get(i).toLowerCase()));
//        	}
//        	catch (AssertionError e) {
//        		System.err.println("Expected list of Income Source 3: " + expectedIncome.get(i) + "\n" +
//        							"Actual list of Income Source 3: " + actualIncome3);
//        		throw e;
//        	}
//		}
        
	}
        @When("the user clicks on Add Another Employer button and enters the following info")
        public void theUserClicksOnAddAnotherEmployerButtonAndEntersTheFollowingInfo(List<Map<String, String>> dataTable) {
        	KaterinaEmployerPage ep = new KaterinaEmployerPage();
        	ep.addEmployer.click();
        	for (Map<String, String> map : dataTable) {
        		ep.employer2.sendKeys(map.get("employer"));
        		ep.position2.sendKeys(map.get("position"));
        		ep.city2.sendKeys(map.get("city"));
        		ep.startDate2.sendKeys(map.get("startDate"));  
        		ep.endDate2.sendKeys(map.get("endDate"));
        		BrowserUtils.waitFor(5);
        	}
        	
        	
        	
        }

        @Then("the user clicks on Clear button and Remove button and gets a confirmation message")
        public void theUserClicksOnClearButtonAndRemoveButtonAGetsAConfirmationMessage() {
        	KaterinaEmployerPage ep = new KaterinaEmployerPage();

        	ep.clearButton2.click();
        	assertTrue(ep.removeBox.isDisplayed());
        	BrowserUtils.waitFor(5);
        	ep.yesButton.click();
        	ep.removeButton2.click();
        	assertTrue(ep.removeBox.isDisplayed());
        	ep.yesButton.click();
        	BrowserUtils.waitFor(5);
        }
        
        @When("the user enter the following info and clicks on Next Button")
        public void theUserEnterTheFollowingInfoAndClicksOnNextButton(List<Map<String, String>> dataTable) {
        	
        	KaterinaEmployerPage ep = new KaterinaEmployerPage();
        	
        	for (Map<String, String> map : dataTable) {
        		ep.employer.sendKeys(map.get("employer"));
        		ep.position.sendKeys(map.get("position"));
        		ep.city.sendKeys(map.get("city"));
        		ep.startDate.sendKeys(map.get("startDate"));  
        		ep.monthlyIncome.sendKeys(map.get("monthlyIncome"));
        		ep.monthlyOvertime.sendKeys(map.get("monthlyOvertime"));
        		ep.monthlyBonus.sendKeys(map.get("monthlyBonus"));
        		ep.monthlyComm.sendKeys(map.get("monthlyComm"));
        		ep.monthlyDiv.sendKeys(map.get("monthlyDiv"));
            	Driver.getDriver().findElement(By.xpath("//*[@id=\"incomesource1\"]/option[3]")).click();
        		ep.amount.sendKeys(map.get("amount"));
        		BrowserUtils.waitFor(5);
        		new KaterinaApplicationPage().nextButton.click();
        	}
            
        }

	 
}
