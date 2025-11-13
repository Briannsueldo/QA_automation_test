package com.project.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.project.pages.LoginPage;
import com.project.utils.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("the user opens the browser {string} and access to login page")
    public void open_browser (String browser) {
        logger.info("===== Starting test with browser: {} =====", browser);
        driver = DriverFactory.createDriver(browser);
        loginPage = new LoginPage(driver);
        loginPage.open();
        logger.info("Login page opened successfully");
    }

    @When("the user enters the username {string}")
    public void insert_username(String username) {
        logger.info("Entering username : '{}'", username.isEmpty() ? "[EMPTY]" : username);
        loginPage.enterUsername(username);
    }

    @And("clear the username field")
    public void clear_username() {
        logger.info("Clearing username field");
        loginPage.clearUsername();
    }

    @When("the user enters the password {string}")
    public void insert_password(String password) {
        logger.info("Entering password : '{}'", password.isEmpty() ? "[EMPTY]" : password);
        loginPage.enterPassword(password);
    }

    @And("clear the password field")
    public void clear_password() {
        logger.info("Clearing password field");
        loginPage.clearPassword();
    }

    @And("clicks the login button")
    public void click_submit() {
        logger.info("Clicking login button");
        loginPage.clickLogin();
    }

    @Then("the error message {string} should be displayed")
    public void verify_error_message(String expectedMessage) {
        logger.info("Verifying error message contains '{}'", expectedMessage);
        String actualMessage = loginPage.getErrorMessage();

        assertThat("Error message validation",
                    actualMessage,
                    containsString(expectedMessage)
        );

        logger.info("Error message verified: '{}'", actualMessage);
    }

    @Then("the user should see the title {string}")
    public void verify_title(String expectedTitle) {
        logger.info("Verifying title: '{}'", expectedTitle);
        String actualTitle = loginPage.getTitle();

        assertThat("Title validation",
                    actualTitle,
                    containsString(expectedTitle)
        );

        logger.info("Title verified: '{}'", actualTitle);
    }

    @And("close the driver")
    public void close_driver() {
        logger.info("Closing browser");
        loginPage.quitDriver();
        logger.info("===== Test completed =====\n");
    }
}
