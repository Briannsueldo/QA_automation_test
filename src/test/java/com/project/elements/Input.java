package com.project.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {
    private WebDriver driver;
    private By locator;

    public Input(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void type(String str) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(str);
    }

    public String getValue() {
        return driver.findElement(locator).getAttribute("value");
    }

    public void clear() {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        element.clear();
    }
}
