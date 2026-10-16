package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutInfoTest extends BaseTest {

	@Test
	public void checkoutinfo() {
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage("standard_user", "secret_sauce");
		
		InventoryPage ip = new InventoryPage(driver);
		ip.addProductToCart("sauce-labs-backpack");
		
		CartPage cp = new CartPage(driver);
		cp.openCart();
		cp.clickCheckout();
		
		CheckoutInfoPage cip = new CheckoutInfoPage(driver);
		cip.enterDetails("Captain", "America", "546372");
		cip.clickContinue();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
	}
}
