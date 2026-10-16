package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String getConfirmationMessage() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();	
	}
	
	public void clickBackHome() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products"))).click();
	}
}
