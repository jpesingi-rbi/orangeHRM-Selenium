package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//*[contains(@class, 'oxd-alert-content-text')]");
    private By adminElement= By.xpath("//*[contains(@class, 'oxd-main-menu-item-wrapper')]");
    private By pimElement= By.xpath("//a[span[text()='PIM']]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public void navigatetoAdmin()
    {
    	driver.findElement(adminElement).click();
    }
    
    public void navigatetoPIM()
    {
    	driver.findElement(pimElement).click();
    }
}
