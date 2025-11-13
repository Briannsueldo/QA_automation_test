package com.project.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    private WebDriver driver;
    private By locator;

    public Button(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void submit () {
        WebElement element = driver.findElement(locator);
        element.click();
    }
}
