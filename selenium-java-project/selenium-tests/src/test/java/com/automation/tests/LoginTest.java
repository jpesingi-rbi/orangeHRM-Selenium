package com.automation.tests;

import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
    	test=extent.createTest("testValidLogin Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed!");
    }

    @Test
    public void testInvalidLogin() {
    	test=extent.createTest("testInvalidLogin Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "invalidPass");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"), "Error message missing!");
    }
}
