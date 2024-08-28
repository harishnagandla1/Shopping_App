package com.epam.uitests.stepDefinition;

import com.epam.uitests.pageclass.SouceDemoPage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SouceDemoSteps {

    private WebDriver driver;
    private SouceDemoPage souceDemoPage;

    public SouceDemoSteps() {
        this.driver = Hooks.getDriver();
        souceDemoPage = new SouceDemoPage(driver);
    }

    @Given("^I am on the Login page$")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("^I enter valid credentials$")
    public void i_enter_valid_credentials() {
        souceDemoPage.login("standard_user", "secret_sauce");
    }

    @Then("^I should be redirected to the homepage$")
    public void i_should_be_redirected_to_the_homepage() {
        Assert.assertTrue("Not redirected to homepage", driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("^I enter invalid credentials$")
    public void i_enter_invalid_credentials() {
        souceDemoPage.login("wrong_user", "wrong_pass");
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() {
        Assert.assertTrue("Error message not displayed", souceDemoPage.isErrorMessageDisplayed());
    }

    @When("^I click on the logout button$")
    public void i_click_on_the_logout_button() {
        souceDemoPage.logout();
    }

    @Then("^I should be logged out$")
    public void i_should_be_logged_out() {
        Assert.assertTrue("Not logged out", driver.getCurrentUrl().contains("index.html"));
    }

    // Additional step definitions for other scenarios
}