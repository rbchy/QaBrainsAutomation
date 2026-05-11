package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import utils.BaseTest;

public class CartSteps {

private WebDriver driver;
private CartPage cartPage;

//Constructor
public CartSteps() {
this.driver = BaseTest.getDriver();
this.cartPage = new CartPage(driver);
}

@When("User adds products to cart")
public void user_adds_products_to_cart() {
//Example: adding the first product
cartPage.addProductToCart(0);
}

@Then("Product should appear in cart")
public void product_should_appear_in_cart() {
boolean isPresent = cartPage.isProductInCart(0);
Assert.assertTrue(isPresent, "❌ Product was not found in the cart after adding");
}

@When("User removes product from cart")
public void user_removes_product_from_cart() {
cartPage.removeProduct(0);
}

@Then("Cart should be empty")
public void cart_should_be_empty() {
boolean isPresent = cartPage.isProductInCart(0);
Assert.assertFalse(isPresent, "❌ Product is still in the cart after removing");
}
}                       


