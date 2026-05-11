package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.RegistrationPage;
import utils.BaseTest;

public class RegistrationSteps {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.driver = BaseTest.getDriver();
        if (this.driver == null) {
            throw new RuntimeException("Driver is null!");
        }
        this.registrationPage = new RegistrationPage(this.driver);
    }

    @When("User navigates to registration page")
    public void user_navigates_to_registration_page() {
        registrationPage.openRegistrationPage();
    }

    @When("User enters valid registration details with email {string}")
    public void user_enters_valid_registration_details_with_email(String email) {
        registrationPage.enterRegistrationDetails(
                "Rezaul Karim",
                "United States",
                "Engineer",
                email,
                "Password123",
                "Password123"
        );
    }

    @When("User enters registration details with email {string}")
    public void user_enters_registration_details_with_email(String email) {
        registrationPage.enterRegistrationDetails(
                "Rezaul Karim",
                "United States",
                "Engineer",
                email,
                "Password123",
                "Password123"
        );
    }

    @When("User clicks on register button")
    public void user_clicks_on_register_button() {
        registrationPage.clickRegister();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(), "Registration failed!");
    }

    @Then("Email validation error message should be displayed")
    public void email_validation_error_message_should_be_displayed() {
        Assert.assertTrue(registrationPage.isEmailValidationMessageDisplayed(), "Email validation error not shown!");
    }
}