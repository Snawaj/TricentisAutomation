package BrowserFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory  {
	
	WebDriver driver;
	Properties prop;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
public WebDriver init_driver(Properties prop) {
	String browserName = prop.getProperty("browser").trim();
	System.out.println("The application is running on > " + browserName);
	
	if(browserName.equalsIgnoreCase("chrome")) {
		tldriver.set(driver = new ChromeDriver()); 	
	}	
	else if (browserName.equalsIgnoreCase("firefox")) {
		tldriver.set(driver = new FirefoxDriver());		
	}	
	else {
		System.out.println("Please pass the browser name in the config file");		
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	driver.get(prop.getProperty("url"));
	return getDriver();
	
}    
public static synchronized WebDriver getDriver() {
	return tldriver.get();
}
	public Properties init_prop() {
	FileInputStream ip = null;
	prop = new Properties();
	try {
		ip = new FileInputStream("./src/main/resources/configuration/config.properties");
	} catch (FileNotFoundException e) {	
		e.printStackTrace();
	}
	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
	
	}

}
