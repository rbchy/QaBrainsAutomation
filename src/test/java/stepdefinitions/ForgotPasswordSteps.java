package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.ForgotPasswordPage;
import utils.BaseTest;

public class ForgotPasswordSteps {
    private WebDriver driver;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        driver = BaseTest.getDriver();
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Given("User is on Forgot Password page")
    public void userIsOnForgotPasswordPage() {
        driver.get("https://practice.qabrains.com/forgot-password");
    }

    @When("User enters registered email {string}")
    public void userEntersRegisteredEmail(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @When("User enters unregistered email {string}")
    public void userEntersUnregisteredEmail(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        forgotPasswordPage.clickSubmit();
    }

    @Then("User should see success message {string}")
    public void userShouldSeeSuccessMessage(String expected) {
        String actual = forgotPasswordPage.getSuccessMessage();
        Assert.assertTrue(actual.contains("reset") || actual.contains("success"));
    }

    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String expected) {
        String actual = forgotPasswordPage.getErrorMessage();
        Assert.assertTrue(actual.contains("@") || actual.contains("not found"));
    }

    @After
    public void tearDown() {
        BaseTest.quitDriver();
    }
}