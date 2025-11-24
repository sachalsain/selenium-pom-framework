package com.sachalsain.selenium.pom.framework.tests;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.listeners.TestListener;
import com.sachalsain.selenium.pom.framework.pages.DashboardPage;
import com.sachalsain.selenium.pom.framework.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
// Attach Listener for screenshots/reporting
@Listeners(TestListener.class)
public class AdvancedLoginTests extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedLoginTests.class);
    private static final String LOG_PREFIX = "[AdvancedLoginTests]";

    @Test(priority = 1, groups = {"smoke"}, description = "Valid login with full assertions")
    public void validLoginFullTest() {
        logger.info("Starting Valid Login Test..." + "-> " + LOG_PREFIX);

        // Create LoginPage object
        logger.info("Creating Login Page..." + "-> " + LOG_PREFIX);
        LoginPage loginPage = new LoginPage(driver);
        // Create Dashboard object
        logger.info("Creating Dashboard Page..." + "-> " + LOG_PREFIX);
        DashboardPage dashboard = new DashboardPage(driver);

        // Perform valid login
        logger.info("Logging in with valid credentials..." + "-> " + LOG_PREFIX);
        loginPage.login("student", "Password123");

        // Assertion 1: URL should change to success page
        logger.info("Asserting URL..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://practicetestautomation.com/logged-in-successfully/",
                "URL mismatch after login");

        // Assertion 2: Validate success message
        logger.info("Asserting Success message..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(dashboard.getSuccessMessage(),
                "Logged In Successfully",
                "Dashboard message mismatch");

        // Assertion 3: Validate page title
        logger.info("Asserting Title..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(driver.getTitle(),
                "Logged In Successfully | Practice Test Automation",
                "Page title mismatch");
        
        logger.info("Valid Login Test Completed Successfully..." + "-> " + LOG_PREFIX);
    }

    @Test(priority = 2, groups = {"regression"}, description = "Invalid login scenario")
    public void invalidLoginTest() {
        logger.info("Starting Invalid Login Test..." + "-> " + LOG_PREFIX);

        // POM login page
        logger.info("Creating Login Page..." + "-> " + LOG_PREFIX);
        LoginPage loginPage = new LoginPage(driver);

        // Perform invalid login
        logger.info("Logging in with invalid credentials..." + "-> " + LOG_PREFIX);
        loginPage.login("wrongUser", "wrongPass");

        // Assertion: error message must match
        logger.info("Asserting Rejection message..." + "-> " + LOG_PREFIX);
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Your username is invalid!",
                "Incorrect error message for invalid login");
        
        logger.info("Invalid Login Test Completed Successfully..." + "-> " + LOG_PREFIX);
    }
}
