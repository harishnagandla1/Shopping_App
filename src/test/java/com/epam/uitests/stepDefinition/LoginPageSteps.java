import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginPageSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("the user is on the login page at {string}")
    public void theUserIsOnTheLoginPage(String url) {
        driver.get(url);
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to their personalized dashboard")
    public void theUserShouldBeRedirectedToTheirPersonalizedDashboard() {
        assertTrue("Not redirected to dashboard", loginPage.isOnDashboard());
    }

    @And("the user should see their order history")
    public void theUserShouldSeeTheirOrderHistory() {
        assertTrue("Order history not visible", loginPage.isOrderHistoryVisible());
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String errorMessage) {
        assertEquals("Error message incorrect", errorMessage, loginPage.getErrorMessage());
    }

    @But("the user should not be redirected to their dashboard")
    public void theUserShouldNotBeRedirectedToTheirDashboard() {
        assertFalse("Unexpectedly redirected to dashboard", loginPage.isOnDashboard());
    }

    @When("the user successfully logs in with valid credentials")
    public void theUserSuccessfullyLogsInWithValidCredentials() {
        loginPage.loginWithValidCredentials("standard_user", "secret_sauce");
    }

    @When("the user enters incorrect credentials more than three times")
    public void theUserEntersIncorrectCredentialsMoreThanThreeTimes() {
        loginPage.enterCredentialsMultipleTimes("standard_user", "wrong_password", 4);
    }

    @Then("the user should see a message indicating login attempts are limited")
    public void theUserShouldSeeMessageIndicatingLoginAttemptsAreLimited() {
        assertTrue("Limit message not visible", loginPage.isLoginLimitMessageVisible());
    }

    @And("the user should be advised to try again later or recover their password")
    public void theUserShouldBeAdvisedToTryAgainLaterOrRecoverTheirPassword() {
        assertTrue("Recovery advice not present", loginPage.isRecoveryAdviceVisible());
    }

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        assertTrue("User not logged out", loginPage.isLoggedOut());
    }

    @And("the user should receive confirmation of successful logout")
    public void theUserShouldReceiveConfirmationOfSuccessfulLogout() {
        assertTrue("Logout confirmation not visible", loginPage.isLogoutConfirmed());
    }

    @And("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        assertTrue("Not redirected to login page", loginPage.isOnLoginPage());
    }
}