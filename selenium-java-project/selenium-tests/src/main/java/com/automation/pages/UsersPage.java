package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UsersPage {
    WebDriver driver;

    private By userTable = By.className("oxd-table");
    private By pagination = By.className("oxd-pagination-page-item");   
    private By nextPageButton = By.xpath("//button[i[contains(@class, 'bi-chevron-right')]]");
    private By previousPageButton = By.xpath("//button[i[contains(@class, 'bi-chevron-left')]]");
    private By userRoleDropdown = By.xpath("//label[contains(text(),'User Role')]/following::div[contains(@class,'oxd-select-text--after')][1]");
    private By statusDropdown = By.xpath("//label[contains(text(),'Status')]/following::div[contains(@class,'oxd-select-text--after')][1]");


    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserTableDisplayed() {
        return driver.findElement(userTable).isDisplayed();
    }

    public int getUserCountOnPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-table-card --mobile')]")));

        List<WebElement> users = driver.findElements(By.xpath("//div[contains(@class, 'oxd-table-card --mobile')]"));
        System.out.print("Users size is......"+users.size());
        
        return users.size();
    }

    public boolean isPaginationDisplayed() {
        return driver.findElement(pagination).isDisplayed();
    }

    public void clickNextPage() {
        driver.findElement(nextPageButton).click();
    }

    public void clickPreviousPage() {
        driver.findElement(previousPageButton).click();
    }

    public void selectUserRole(String role) {
    	driver.findElement(userRoleDropdown).click();
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

    	for (WebElement option : options) {
    	    if (option.getText().trim().equals(role)) { 
    	        option.click();  
    	        break;  
    	    }
    	}
    }

    public void selectStatus(String status) {
    	driver.findElement(statusDropdown).click(); 
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

    	for (WebElement option : options) {
    	    if (option.getText().trim().equals(status)) { 
    	        option.click();  
    	        break;  
    	    }
    	}
    }
}
