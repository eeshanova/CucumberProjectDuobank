package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class KatyaPage {
	
	public KatyaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
