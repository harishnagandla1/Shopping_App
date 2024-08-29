import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
  WebDriver driver;
  WebDriverWait wait;
  LoginPage loginPage;

  @Given("the user is directed to the login page at {string}")
  public void the_user_is_directed_to_the_login_page_at(String url) {
    driver.get(url);
    loginPage = new LoginPage(driver);
  }

  @When("the user enters valid username and password")
  public void the_user_enters_valid_username_and_password() {
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
  }

  @When("the user enters username {string} and password {string}")
  public void the_user_enters_username_and_password(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
  }

  @And("the user clicks on the login button")
  public void the_user_clicks_on_the_login_button() {
    loginPage.clickLoginButton();
  }

  @Then("the user should be logged in successfully")
  public void the_user_should_be_logged_in_successfully() {
    InventoryPage inventoryPage = loginPage.successfulLogin();
    // Assert user is on the inventory page
  }

  @Then("the user should receive an error message {string}")
  public void the_user_should_receive_an_error_message(String expectedError) {
    String actualError = loginPage.getErrorMessage();
    // Assert error message equals expectedError
  }

  @But("the user should not be redirected to the inventory page")
  public void the_user_should_not_be_redirected_to_the_inventory_page() {
    // Assert user is still on the login page
  }

  // Similar step definitions for logout and other scenarios
}