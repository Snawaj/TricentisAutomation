package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericMethods {
	WebDriver driver;
	
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
		
	}
	public By getBy(String locatorType, String value) {
		
		By locator = null;
		
		switch(locatorType.toLowerCase()) {
		case "id": locator = By.id(value);
		case "name": locator = By.name(value);
		case "className": locator = By.className(value);
		case "cssSelector": locator = By.cssSelector(value);
		case "xpath": locator = By.xpath(value);
		case "partialLinkText": locator = By.partialLinkText(value);
		case "linkText": locator = By.linkText(value);
		case "tagName": locator = By.tagName(value);
		}		
		return locator;	
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public void doClick(By locator) {
	driver.findElement(locator).click();		
	}
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();	
	}
	public void doSendKey(By locator, String value) {
	driver.findElement(locator).clear();
	driver.findElement(locator).sendKeys(value);
	}
	public void doDropDownByVisibleText (By locator, String value) {
		Select drpDown = new Select ((WebElement)driver.findElement(locator));
		drpDown.selectByVisibleText(value);
		}
		public void doDropDownByValue (By locator, String value) {
		Select drpDown = new Select ((WebElement)driver.findElement(locator));
		drpDown.selectByValue(value);
		}
		public void doDropDownByIndex (By locator, int value) {
		Select drpDown = new Select ((WebElement)driver.findElement(locator));
		drpDown.selectByIndex(value);
		}
}
