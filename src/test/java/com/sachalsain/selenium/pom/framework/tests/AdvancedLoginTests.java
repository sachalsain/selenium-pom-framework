package com.sachalsain.selenium.pom.framework.tests;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.listeners.TestListener;
import com.sachalsain.selenium.pom.framework.pages.DashboardPage;
import com.sachalsain.selenium.pom.framework.pages.LoginPage;
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

    @Test(priority = 1, groups = {"smoke"}, description = "Valid login with full assertions")
    public void validLoginFullTest() {

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        // Create Dashboard object
        DashboardPage dashboard = new DashboardPage(driver);

        // Perform valid login
        loginPage.login("student", "Password123");

        // Assertion 1: URL should change to success page
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://practicetestautomation.com/logged-in-successfully/",
                "URL mismatch after login");

        // Assertion 2: Validate success message
        Assert.assertEquals(dashboard.getSuccessMessage(),
                "Logged In Successfully",
                "Dashboard message mismatch");

        // Assertion 3: Validate page title
        Assert.assertEquals(driver.getTitle(),
                "Logged In Successfully | Practice Test Automation",
                "Page title mismatch");
    }

    @Test(priority = 2, groups = {"regression"}, description = "Invalid login scenario")
    public void invalidLoginTest() {

        // POM login page
        LoginPage loginPage = new LoginPage(driver);

        // Perform invalid login
        loginPage.login("wrongUser", "wrongPass");

        // Assertion: error message must match
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Your username is invalid!",
                "Incorrect error message for invalid login");
    }
}
