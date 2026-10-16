package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInfoPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutInfoPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterDetails(String firstname,String lastname,String zip) {
		driver.findElement(By.id("first-name")).sendKeys(firstname);
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		driver.findElement(By.id("postal-code")).sendKeys(zip);
		}

	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
	}
	
	public void clickFinish() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
	}
}
