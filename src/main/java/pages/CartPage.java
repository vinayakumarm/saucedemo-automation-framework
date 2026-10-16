package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void openCart() {
		driver.findElement(By.className("shopping_cart_link")).click();
	}
	
	public String getCartCount() {
		
		if(driver.findElements(By.className("shopping_cart_badge")).size() == 0) {
			return "";
		}
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))).getText();
	}
	
	public void removeFromCart() {
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Remove']"))).click();
	}
	
	public void clickCheckout() {
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
	}
}
