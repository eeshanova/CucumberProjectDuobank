package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class KaterinaPage {
	
	public KaterinaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
