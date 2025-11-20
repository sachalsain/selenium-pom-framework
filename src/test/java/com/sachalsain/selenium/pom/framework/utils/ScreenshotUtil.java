package com.sachalsain.selenium.pom.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class ScreenshotUtil {

    // Method to capture screenshot
    public static String takeScreenshot(WebDriver driver, String testName) {
        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Save path
        String filePath = "screenshots/" + testName + ".png";

        try {
            // Create dir if missing
            Files.createDirectories(new File("screenshots/").toPath());
            // Copy image to folder
            Files.copy(src.toPath(), new File(filePath).toPath());
        } catch (IOException e) {
            // Print error if fails
            e.printStackTrace();
        }
        // Return screenshot path
        return filePath;
    }
}
