package com.sachalsain.selenium.pom.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tahreem J. Naseem (www.tahreems.com / +92-333-443-8775) {TECHBYTES}
 */
public class SeleniumPomFramework {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumPomFramework.class);
    private static final String LOG_PREFIX = "[SeleniumPomFramework]";

    public static void main(String[] args) {
        logger.debug("{} Starting SeleniumPomFramework..." + "-> " + LOG_PREFIX);
        System.out.println("Hello World!");
    }
}
