package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.GenericMethods;

public class DemoPage {
	
	private WebDriver driver;
	private GenericMethods gm;
	
	//1. Object Repository - by locator
	private By string = By.id("");
	
	
	//2. Constructor --
	public DemoPage(WebDriver driver) {
		this.driver = driver;
		gm = new GenericMethods(this.driver);
		
	}
	//3. Actions
	public void setActions() {
		gm.doClick(string);
	}
	

}
