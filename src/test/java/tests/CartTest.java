package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
	
	@Test

	public void cartTest() {
		
	LoginPage lp = new LoginPage(driver);
	lp.loginPage("standard_user", "secret_sauce");
	
	InventoryPage ip = new InventoryPage(driver);
	ip.addProductToCart("sauce-labs-backpack");
	
	CartPage cp = new CartPage(driver);
	
	cp.openCart();
	
	String cc = cp.getCartCount();
	System.out.println("Cart count before removing : " + cc);
	
	Assert.assertEquals(cc, "1");
	
	cp.removeFromCart();
	
	String cc1 = cp.getCartCount();
	System.out.println("Cart count after removing : " + cc1);
	
	Assert.assertEquals(cc1, "");
	
	}
}
