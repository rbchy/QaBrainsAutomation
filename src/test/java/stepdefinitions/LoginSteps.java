package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.BaseTest;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        driver = BaseTest.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login("qa_testers@qabrains.com", "Password123");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.login("wrong@test.com", "wrongpass");
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        boolean isSuccess = loginPage.isLoginSuccessful();
        System.out.println("✅ Login Success Status: " + isSuccess);
        Assert.assertTrue(isSuccess, "❌ Login was not successful");
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        boolean isError = loginPage.isErrorDisplayed();
        System.out.println("🔴 Error Display Status: " + isError);
        Assert.assertTrue(isError, "❌ Error message not displayed");
    }
}