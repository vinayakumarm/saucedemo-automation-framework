package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

	@Test
	public void addToCart() {
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage("standard_user", "secret_sauce");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed : inventory page is not displayed");
		
		InventoryPage ip = new InventoryPage(driver);
		
		int count = ip.totalProducts();
		System.out.println("Products available to add : " + count);
		Assert.assertEquals(count, 6);
		
		ip.addProductToCart("sauce-labs-backpack");
		ip.sortBy("lohi");
		List<Double> p = ip.prices();
		System.out.println("prices" + p);
		
		List<Double> sorted = new ArrayList<Double>(p);
		Collections.sort(sorted);
		Assert.assertEquals(p, sorted, "Prices are not sorted low to high");
		
	}
}
