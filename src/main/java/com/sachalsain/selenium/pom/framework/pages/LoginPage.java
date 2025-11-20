package com.sachalsain.selenium.pom.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class LoginPage {

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
        this.driver = driver;
    }

    // Action: Enter email
    public void enterUsername(String username) {
        // Type the username into field
        driver.findElement(usernameField).sendKeys(username);
    }

    // Action: Enter password
    public void enterPassword(String password) {
        // Type password into field
        driver.findElement(passwordField).sendKeys(password);
    }

    // Action: Click login button
    public void clickLogin() {
        // Press the login button
        driver.findElement(loginButton).click();
    }

    // Combined Action: Perform login
    public void login(String username, String password) {
        // Fill email
        enterUsername(username);
        // Fill password
        enterPassword(password);
        // Submit form
        clickLogin();
    }

    // Action: Get error message text
    public String getErrorMessage() {
        // Return login error text
        return driver.findElement(errorMessage).getText();
    }
}
