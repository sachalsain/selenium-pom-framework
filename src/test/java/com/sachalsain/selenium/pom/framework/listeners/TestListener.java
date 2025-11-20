package com.sachalsain.selenium.pom.framework.listeners;

import com.sachalsain.selenium.pom.framework.base.BaseTest;
import com.sachalsain.selenium.pom.framework.utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Get test name
        String testName = result.getName();

        // Get driver from BaseTest
        BaseTest base = (BaseTest) result.getInstance();
        // Capture screenshot on failure
        ScreenshotUtil.takeScreenshot(base.driver, testName);
    }

}
