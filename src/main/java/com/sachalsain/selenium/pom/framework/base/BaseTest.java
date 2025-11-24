package com.sachalsain.selenium.pom.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final String LOG_PREFIX = "[BaseTest]";

    // Public so tests can access it
    public WebDriver driver;

    // Setup driver before each test
    @BeforeMethod
    public void setUp() {

        // Launch Chrome browser
        logger.info("Starting browser..." + "-> " + LOG_PREFIX);
        driver = new ChromeDriver();
        // Maximize window
        logger.info("Maximizing window..." + "-> " + LOG_PREFIX);
        driver.manage().window().maximize();
        // Open login page for testing
        logger.info("Navigating to login page: 'https://practicetestautomation.com/practice-test-login/' ..." + "-> " + LOG_PREFIX);
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    // Quit driver after each test
    @AfterMethod
    public void tearDown() {
        // Close browser & end session
        logger.info("Closing browser session..." + "-> " + LOG_PREFIX);
        driver.quit();
    }
}
