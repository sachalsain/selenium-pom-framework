package com.sachalsain.selenium.pom.framework.tests;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.pages.DashboardPage;
import com.sachalsain.selenium.pom.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {

        // Instantiate POM pages
        // Create object of LoginPage
        LoginPage loginPage = new LoginPage(driver);
        // Create dashboard object
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Perform login with valid credentials
        // Call login method
        loginPage.login("student", "Password123");

        // Check if dashboard welcome message appears
        // Read welcome message
        String message = dashboardPage.getSuccessMessage();
        // Validate login success
        Assert.assertEquals(message, "Logged In Successfully");
    }

    @Test
    public void invalidLoginTest() {
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with wrong credentials
        loginPage.login("wrongUser", "wrongpass");

        // Validate error message
        Assert.assertEquals(loginPage.getErrorMessage(),
                // Expected error text
                "Your username is invalid!");
    }
}
