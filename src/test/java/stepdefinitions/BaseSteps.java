package stepdefinitions;

import data.User;
import io.cucumber.java.en.And;
import pages.LoginPage;

public class BaseSteps {

    @And("I login as a {}")
    public void iLoginAsAUser(User user) {
        new LoginPage().loginAsUser(user);
    }
}
