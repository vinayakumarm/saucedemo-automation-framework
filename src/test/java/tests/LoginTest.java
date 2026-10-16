package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginTest() {
	LoginPage lp = new LoginPage(driver);
	lp.loginPage("standard_user", "secret_sauce");
	Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}
	
	@Test
	public void invalidLoginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginPage("invalid_user", "wrong_password");
		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));
	}
	
	@Test
	public void lockedOutUserTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginPage("locked_out_user", "secret_sauce");
		Assert.assertTrue(lp.getErrorMessage().contains("locked out"));
	}
}
