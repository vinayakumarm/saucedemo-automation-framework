package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	String url = "https://www.saucedemo.com/";
	
	@BeforeMethod
	public void setUp() {
		String key = "webdriver.gecko.driver";
		String value = ".\\Softwares1\\geckodriver.exe";
		System.setProperty(key, value);
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
