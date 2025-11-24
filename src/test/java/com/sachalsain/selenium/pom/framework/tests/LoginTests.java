package com.sachalsain.selenium.pom.framework.tests;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.pages.DashboardPage;
import com.sachalsain.selenium.pom.framework.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class LoginTests extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTests.class);
    private static final String LOG_PREFIX = "[LoginTests]";

    @Test
    public void validLoginTest() {
        logger.info("Starting Old Valid Login Test..." + "-> " + LOG_PREFIX);

        // Instantiate POM pages
        // Create object of LoginPage
        logger.info("Creating Login Page..." + "-> " + LOG_PREFIX);
        LoginPage loginPage = new LoginPage(driver);
        // Create dashboard object
        logger.info("Creating Dashboard Page..." + "-> " + LOG_PREFIX);
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Perform login with valid credentials
        // Call login method
        logger.info("Logging in with valid credentials..." + "-> " + LOG_PREFIX);
        loginPage.login("student", "Password123");

        // Check if dashboard welcome message appears
        // Read welcome message
        String message = dashboardPage.getSuccessMessage();
        // Validate login success
        logger.info("Asserting Success message..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(message, "Logged In Successfully");
        
        logger.info("Valid Login Test Completed Successfully..." + "-> " + LOG_PREFIX);
    }

    @Test
    public void invalidLoginTest() {
        logger.info("Starting Invalid Login Test..." + "-> " + LOG_PREFIX);
        // Create LoginPage object
        logger.info("Creating Login Page..." + "-> " + LOG_PREFIX);
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with wrong credentials
        logger.info("Logging in with invalid credentials..." + "-> " + LOG_PREFIX);
        loginPage.login("wrongUser", "wrongpass");

        // Validate error message
        logger.info("Asserting Rejection message..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(loginPage.getErrorMessage(),
                // Expected error text
                "Your username is invalid!");
        
        logger.info("Invalid Login Test Completed Successfully..." + "-> " + LOG_PREFIX);
    }
}
