package com.automation.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.reports.ExtentReportManager;
import com.aventstack.extentreports.Status;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    
    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();  // Get ExtentReports instance from ExtentManager
    }

    @BeforeClass
    public void setup() {
    	  extent = ExtentReportManager.getInstance();
          test = extent.createTest("Setup Test");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginBtn = driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-login-branding')]"));
        test.log(Status.INFO, "Browser launched and navigated to login page");

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterSuite
    public void tearDownReport() {
        extent.flush();  
    }
    
}
