package com.sachalsain.selenium.pom.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class BaseTest {

    // Public so tests can access it
    public WebDriver driver;

    // Setup driver before each test
    @BeforeMethod
    public void setUp() {

        // Launch Chrome browser
        driver = new ChromeDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Open login page for testing
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    // Quit driver after each test
    @AfterMethod
    public void tearDown() {
        // Close browser & end session
        driver.quit();
    }
}
