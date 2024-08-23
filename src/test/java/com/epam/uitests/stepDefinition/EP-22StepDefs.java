import org.openqa.selenium.WebDriver;

public class EP-22StepDefs {
    private WebDriver driver;

    @Given("^I am on the registration page$")
    public void i_am_on_the_registration_page() {
        driver.get("http://example.com/registration");
    }

    @When("^I enter valid user details$")
    public void i_enter_valid_user_details() {
        // Code to enter user details
    }

    @When("^I submit the registration form$")
    public void i_submit_the_registration_form() {
        // Code to submit form
    }

    @Then("^I should be registered successfully$")
    public void i_should_be_registered_successfully() {
        // Code to verify registration
    }

    @When("^I enter an invalid email format$")
    public void i_enter_an_invalid_email_format() {
        // Code to enter invalid email
    }

    @Then("^I should see an error message about invalid email format$")
    public void i_should_see_an_error_message_about_invalid_email_format() {
        // Code to verify error message
    }
}