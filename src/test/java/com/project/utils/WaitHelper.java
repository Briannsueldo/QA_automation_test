package com.project.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitHelper {
    private static final Logger logger = LogManager.getLogger(WaitHelper.class);
    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 3;
    private static final int DEFAULT_POLLING = 500;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementVisible(By locator) {
        logger.debug("Waiting for element to be visible: {}", locator);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
            .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("Element not found or not visible: " + locator);

        return wait.until(driver -> {
            WebElement element = driver.findElement(locator);

            if (element.isDisplayed()) {
                logger.debug("Element found: '{}'", locator);
                return element;
            }

            return null;
        });
    }
}
