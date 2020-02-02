package com.weborders.step_definitons;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    //to create login page object
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("I login as tester")
    public void i_login_as_tester() {
        loginPage.login();
    }

    @Then("I verify that {string} logo is displayed")
    public void i_verify_that_logo_is_displayed(String string) {
        Assert.assertEquals("Logo text is not correct!", string, loginPage.getPageLogoText());
    }

}
