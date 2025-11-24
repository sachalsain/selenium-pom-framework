package com.sachalsain.selenium.pom.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class LoginPage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final String LOG_PREFIX = "[LoginPage]";

    // WebDriver instance for this page
    private WebDriver driver;

    // Locators (Object Repository)
    // Username input field
    private By usernameField = By.id("username");
    // Password input field
    private By passwordField = By.id("password");
    // Login button
    private By loginButton = By.id("submit");
    // Error message locator
    private By errorMessage = By.id("error");

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        // Assign driver to current page
        logger.info("Assigning the driver..." + "-> " + LOG_PREFIX);
        this.driver = driver;
    }

    // Action: Enter email
    public void enterUsername(String username) {
        // Type the username into field
        logger.info("Entering username: {}", username + "-> " + LOG_PREFIX);
        driver.findElement(usernameField).sendKeys(username);
    }

    // Action: Enter password
    public void enterPassword(String password) {
        // Type password into field
        logger.info("Entering password: {}", password + "-> " + LOG_PREFIX);
        driver.findElement(passwordField).sendKeys(password);
    }

    // Action: Click login button
    public void clickLogin() {
        // Press the login button
        logger.info("Clicking Login button" + "-> " + LOG_PREFIX);
        driver.findElement(loginButton).click();
    }

    // Combined Action: Perform login
    public void login(String username, String password) {
        logger.info("Performing login with username={} password={}", username, password + "-> " + LOG_PREFIX);
        // Fill username
        enterUsername(username);
        // Fill password
        enterPassword(password);
        // Submit form
        clickLogin();
    }

    // Action: Get error message text
    public String getErrorMessage() {
        // Return login error text
        logger.info("Fetching error message..." + "-> " + LOG_PREFIX);
        return driver.findElement(errorMessage).getText();
    }
}
