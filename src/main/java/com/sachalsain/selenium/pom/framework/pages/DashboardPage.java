package com.sachalsain.selenium.pom.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class DashboardPage {

    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private static final String LOG_PREFIX = "[DashboardPage]";

    private WebDriver driver;

    // Dummy locator for a welcome message
    // Dashboard welcome text
    private By successMessage = By.xpath("//h1");

    public DashboardPage(WebDriver driver) {
        // Assign driver
        logger.info("Assigning the driver..." + "-> " + LOG_PREFIX);
        this.driver = driver;
    }

    // Action: Read welcome message
    public String getSuccessMessage() {
        // Retrieve welcome message
        logger.info("Fetching success message from dashboard..." + "-> " + LOG_PREFIX);
        return driver.findElement(successMessage).getText();
    }
}
