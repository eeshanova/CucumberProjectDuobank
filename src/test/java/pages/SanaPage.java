package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SanaPage {
	
	public SanaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
