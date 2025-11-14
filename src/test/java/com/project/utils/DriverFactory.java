package com.project.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    
    public static WebDriver createDriver(String browser) {
        logger.info("Creating WebDriver for browser: {}", browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                logger.info("Initializing ChromeDriver");
                return new ChromeDriver();
            case "edge":
                logger.info("Initializing EdgeDriver");
                return new EdgeDriver();
            case "firefox":
                logger.info("Initializing FirefoxDriver");
                return new FirefoxDriver();
            default:
                logger.error("Unsupported browser: {}", browser);
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
