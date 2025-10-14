package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class CartSteps {

    @When("I add the highest priced item to the cart")
    public void iAddTheHighestPricedItemToTheCart() {
        new ProductPage().addHighestPricedItemToCart();
    }

    @Then("the shopping cart count should be {int}")
    public void theShoppingCartCountShouldBe(int expectedCount) {
        assertEquals(new ProductPage().getShoppingCartCount(), expectedCount, "Shopping cart count mismatch");
    }
}