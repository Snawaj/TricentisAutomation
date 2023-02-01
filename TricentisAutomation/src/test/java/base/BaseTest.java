package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserFactory.DriverFactory;
import Pages.AutomobilePage;
import Pages.DemoPage;
import Pages.LoginPage;
import Utils.GenericMethods;

public class BaseTest {
	WebDriver driver;
	
	protected DriverFactory df;
	protected Properties prop;
	protected GenericMethods gm;
	
	protected DemoPage demoPage;
	protected AutomobilePage automobilePage;
	protected LoginPage loginPage;

	@BeforeTest
	public void Setup() {
		
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		
		automobilePage = new AutomobilePage(driver);
		demoPage = new DemoPage(driver);
		loginPage = new LoginPage (driver);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		
	}
	
	
	
	
	
	
	

}
