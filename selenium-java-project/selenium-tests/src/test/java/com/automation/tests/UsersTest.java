package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.pages.UsersPage;
import com.aventstack.extentreports.Status;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    @Test
    public void testUserListDisplay() {
        LoginPage loginPage = new LoginPage(driver);
       // loginPage.login("Admin", "admin123");
        loginPage.navigatetoAdmin();
        UsersPage userPage = new UsersPage(driver);
        Assert.assertTrue(userPage.isUserTableDisplayed(), "User list is not displayed!");
    }

    @Test
    public void testPagination() {
    	test=extent.createTest(" testPagination Test");
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login("Admin", "admin123");
        loginPage.navigatetoPIM();
        UsersPage userPage = new UsersPage(driver);
        Assert.assertTrue(userPage.isPaginationDisplayed(), "Pagination is not displayed!");

        int initialUserCount = userPage.getUserCountOnPage();
        System.out.print("Initial user count" + initialUserCount);
        
        userPage.clickNextPage();
        
        int nextPageUserCount = userPage.getUserCountOnPage();
        System.out.print("next page user count" + nextPageUserCount);

        Assert.assertTrue(initialUserCount > 0, "User count should be greater than zero");
        Assert.assertTrue(nextPageUserCount > 0, "User count should be greater than zero");
    }

    @Test
    public void testDropdownFilters() {
    	test=extent.createTest("testDropdownFilters Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        loginPage.navigatetoAdmin();
        UsersPage userPage = new UsersPage(driver);

        userPage.selectUserRole("Admin");
        userPage.selectStatus("Enabled");

        Assert.assertTrue(userPage.isUserTableDisplayed(), "Filtered user list is not displayed!");
        test.log(Status.PASS, "Filtered user list is displayed!");
    }
}
