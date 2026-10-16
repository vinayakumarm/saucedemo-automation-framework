package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest{

	@Test
	public void logout() {
		LoginPage lp = new LoginPage(driver);
		lp.loginPage("standard_user", "secret_sauce");
		
		LogoutPage logout = new LogoutPage(driver);
		logout.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
	}
}
