package com.sachalsain.selenium.pom.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class DashboardPage {

    private WebDriver driver;

    // Dummy locator for a welcome message
    // Dashboard welcome text
    private By successMessage = By.xpath("//h1");

    public DashboardPage(WebDriver driver) {
        // Assign driver
        this.driver = driver;
    }

    // Action: Read welcome message
    public String getSuccessMessage() {
        // Retrieve welcome message
        return driver.findElement(successMessage).getText();
    }
}
