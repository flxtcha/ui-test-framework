package pages;

import data.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.Hooks.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage {

    @FindBy(css = "[data-test='username']")
    private WebElement usernameField;
    @FindBy(css = "[data-test='password']")
    private WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;

    public LoginPage() {
        initElements(getDriver(), this);
    }

    public ProductPage loginAsUser(User user) {
        usernameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return new ProductPage();
    }
}