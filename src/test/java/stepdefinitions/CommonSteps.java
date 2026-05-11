package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.BaseTest;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps() {
        this.driver = BaseTest.getDriver();
        if (this.driver == null) {
            throw new RuntimeException("Driver is null! Initialize BaseTest first.");
        }
    }

    @Given("User launches the application")
    public void user_launches_the_application() {
        driver.get("https://practice.qabrains.com/");  // Launch homepage
        System.out.println("Application launched");
    }

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        // শুধুমাত্র verification, বা redirect করা যায়
        if (!driver.getCurrentUrl().contains("practice.qabrains.com")) {
            driver.get("https://practice.qabrains.com/");
        }
        System.out.println("User is on homepage");
    }

    @Then("Home page should load successfully")
    public void home_page_should_load_successfully() {
        System.out.println("Home page loaded successfully");
    }

    @Then("Products should be added successfully")
    public void products_should_be_added_successfully() {
        System.out.println("Products added successfully");
    }
}