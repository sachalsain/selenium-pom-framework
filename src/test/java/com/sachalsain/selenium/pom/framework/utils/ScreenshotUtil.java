package com.sachalsain.selenium.pom.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class ScreenshotUtil {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtil.class);
    private static final String LOG_PREFIX = "[ScreenshotUtil]";

    // Method to capture screenshot
    public static String takeScreenshot(WebDriver driver, String testName) {
        // Capture screenshot
        logger.error("Capturing Screenshot..." + "-> " + LOG_PREFIX);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Save path
        logger.error("Creating FilePath..." + "-> " + LOG_PREFIX);
        String filePath = "screenshots/" + testName + System.currentTimeMillis() + ".png";
        logger.error("Created FilePath: " + filePath + " -> " + LOG_PREFIX);

        try {
            // Create dir if missing
            logger.error("Creating Directories for filePath..." + "-> " + LOG_PREFIX);
            Files.createDirectories(new File("screenshots/").toPath());
            // Copy image to folder
            logger.error("Saving file to filePath..." + "-> " + LOG_PREFIX);
            Files.copy(src.toPath(), new File(filePath).toPath());
        } catch (IOException e) {
            // Print error if fails
            logger.error("Error Creating filePath. Reason: ", e.getMessage() + "-> " + LOG_PREFIX);
            e.printStackTrace();
        }
        // Return screenshot path
        return filePath;
    }
}
