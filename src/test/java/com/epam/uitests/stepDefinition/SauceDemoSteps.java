package com.epam.uitests.stepDefinition;

import org.openqa.selenium.WebDriver;
import com.epam.uitests.pageclass.LoginPage;

public class SauceDemoSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public SauceDemoSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    @Given("^I am on the SauceDemo login page$")
    public void i_am_on_the_SauceDemo_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("^I enter valid credentials$")
    public void i_enter_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("^I should be redirected to the product page$")
    public void i_should_be_redirected_to_the_product_page() {
        assert(driver.getTitle().contains("Products"));
    }
}