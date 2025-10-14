package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static driver.Hooks.getDriver;
import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ProductPage {

    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> inventoryItemPrices;
    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement shoppingCartCount;

    public ProductPage() {
        initElements(getDriver(), this);
    }

    public ProductPage addHighestPricedItemToCart() {
        WebElement highestPriceItem = inventoryItemPrices.stream()
                .max(comparing(item -> Float.parseFloat(item.getText().replace("$", ""))))
                .orElseThrow(() -> new RuntimeException("No items found"));
        highestPriceItem.findElement(By.xpath("following::button[text()='Add to cart']")).click();
        return new ProductPage();
    }

    public Integer getShoppingCartCount() {
        return parseInt(shoppingCartCount.getText());
    }
}