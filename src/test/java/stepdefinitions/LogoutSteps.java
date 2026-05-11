package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.LogoutPage;
import utils.BaseTest;

public class LogoutSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    public LogoutSteps() {
        this.driver = BaseTest.getDriver();
        this.loginPage = new LoginPage(this.driver);
        this.logoutPage = new LogoutPage(this.driver);
    }

    @Given("User is logged in")
    public void user_is_logged_in() {

        loginPage.login("qa_testers@qabrains.com", "Password123");

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "❌ Logout টেস্টের জন্য লগইন সফল হয়নি!"
        );
    }

    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {

        logoutPage.clickLogout();
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully() {

        Assert.assertTrue(
                logoutPage.isLogoutSuccessful(),
                "❌ Logout সফল হয়নি!"
        );
    }
}