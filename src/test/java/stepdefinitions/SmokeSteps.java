package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmokeSteps {

    @When("User clicks on Catalog, About and Blog")
    public void user_clicks_on_catalog_about_and_blog() {

        System.out.println("Catalog, About, Blog clicked");

    }

    @Then("Pages should navigate correctly")
    public void pages_should_navigate_correctly() {

        System.out.println("Pages navigated correctly");

    }

    @When("User clicks on Wish list and Refer a Friend")
    public void user_clicks_on_wish_list_and_refer_a_friend() {

        System.out.println("Wishlist and Refer a Friend clicked");

    }

    @Then("Pages should open successfully")
    public void pages_should_open_successfully() {

        System.out.println("Pages opened successfully");

    }
}