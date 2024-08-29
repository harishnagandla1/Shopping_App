public class LoginSteps {
    LoginPage loginPage = new LoginPage(driver);

    @Given("^user is on the login page$")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("^user enters username "([^"]*)" and password "([^"]*)"$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("^user is redirected to the dashboard$")
    public void user_is_redirected_to_dashboard() {
        assertThat(driver.getCurrentUrl(), is("https://www.saucedemo.com/inventory.html"));
    }
}