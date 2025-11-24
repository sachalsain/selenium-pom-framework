package com.sachalsain.selenium.pom.framework.listeners;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.utils.ScreenshotUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);
    private static final String LOG_PREFIX = "[TestListener]";

    @Override
    public void onTestFailure(ITestResult result) {
        // Get test name
        logger.error("Retrieving the Test name..." + "-> " + LOG_PREFIX);
        String testName = result.getName();
        logger.error("Retried the Test name...", testName + "-> " + LOG_PREFIX);

        // Get driver from BaseTest
        logger.error("Retrieving the Base Driver..." + "-> " + LOG_PREFIX);
        BaseTest base = (BaseTest) result.getInstance();
        // Capture screenshot on failure
        logger.error("Taking Screenshot..." + "-> " + LOG_PREFIX);
        ScreenshotUtil.takeScreenshot(base.driver, testName);
    }
}
