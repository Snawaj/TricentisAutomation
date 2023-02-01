package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Utils.GenericMethods;

public class AutomobilePage {
	
	private WebDriver driver;
	private GenericMethods gm;
	
	//1. Object Repository - by locator
	private By logo = By.xpath("//img[@id='tricentis_logo']");
	private By nav = By.xpath("//a[@id='nav_automobile']");
	private By make = By.xpath("//select[@id='make']");
	private By eng = By.xpath("//input[@id='engineperformance']");
	private By manf = By.xpath("//input[@id='dateofmanufacture']");
	private By seats = By.xpath("//select[@id='numberofseats']");
	private By fuel= By.xpath("//select[@id='fuel']");
	private By price = By.xpath("//input[@id='listprice']");
	private By licence = By.xpath("//input[@id='licenseplatenumber']");
	private By mileage = By.xpath("//input[@id='annualmileage']");

			
	//2. Constructor --
	public AutomobilePage(WebDriver driver) {
		this.driver = driver;
		gm = new GenericMethods(this.driver);
		
	}
	
	//3. Actions
	
	public void verifyTitle () {
		String url = driver.getCurrentUrl();
		Reporter.log(url);
		String title = driver.getTitle();
		Reporter.log(title);
		}
	
	
	public void completeFormWithValidData() {
	gm.doClick(nav);	
	gm.doDropDownByVisibleText(make, "BMW");
	gm.doSendKey(eng, "3.5");
	gm.doSendKey(manf, "2010");
	gm.doDropDownByVisibleText(seats, "4");
	gm.doDropDownByVisibleText(fuel, "Gas");
	gm.doSendKey(price, "30");
	gm.doSendKey(licence, "GA300");
	gm.doSendKey(mileage, "20");
			
	}
	

}
