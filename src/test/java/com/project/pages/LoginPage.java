package com.project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.elements.Button;
import com.project.elements.Input;
import com.project.utils.WaitHelper;

public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;
    private WaitHelper waitHelper;
    private Input usernameInput;
    private Input passwordInput;
    private Button submitButton;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        usernameInput = new Input(driver, By.xpath("//*[@id='user-name']"));
        passwordInput = new Input(driver, By.xpath("//*[@id='password']"));
        submitButton = new Button(driver, By.xpath("//*[@id='login-button']"));
    }

    public void open() {
        logger.info("Navigating to https://www.saucedemo.com");
        driver.get("https://www.saucedemo.com");
    }

    public void enterUsername(String username) {
        logger.debug("Entering username");
        usernameInput.type(username);
    }

    public void clearUsername() {
        logger.debug("Clearing username field");
        usernameInput.clear();
    }

    public void enterPassword(String password) {
        logger.debug("Entering password");;
        passwordInput.type(password);
    }

    public void clearPassword() {
        logger.debug("Clearing password field");
        passwordInput.clear();
    }

    public String getUsernameValue() {
        logger.debug("Getting username from field");;
        return usernameInput.getValue();
    }

    public String getPasswordValue() {
        logger.debug("Getting password from field");
        return passwordInput.getValue();
    }

    public void clickLogin() {
        logger.debug("Clicking login button");
        submitButton.submit();
    }

    public void quitDriver() {
        logger.info("Closing browser");
        driver.quit();
    }

    // Methods to get the erros and web title

    public String getErrorMessage() {
        logger.debug("Getting error message from input field");
        WebElement errorElement = waitHelper
            .waitForElementVisible(By.xpath("//h3[@data-test='error']")
        );
        return errorElement.getText();
    }

    public String getTitle() {
        logger.debug("Getting web title");
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div"));
        return titleElement.getText();
    }
}
