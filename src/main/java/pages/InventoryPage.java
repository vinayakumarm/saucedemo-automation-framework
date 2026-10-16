package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InventoryPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public int totalProducts() {
		return driver.findElements(By.xpath("//button[.='Add to cart']")).size();
	}
	
	public void addProductToCart(String productId) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-" + productId))).click();
	}
	
	public void sortBy(String value) {
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
		
		Select sl = new Select(dropdown);
		sl.selectByValue(value);
		}
	
	public List<Double> prices() {
		List<Double> prices = new ArrayList<Double>();
		List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
	for (WebElement e :elements) {
		prices.add(Double.parseDouble(e.getText().replace("$", "")));
	}
	return prices;
	}
	
	

	
}
