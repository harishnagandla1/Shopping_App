import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = ".error-message")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public boolean isOnDashboard() {
        // Implementation to check if on dashboard
    }

    public boolean isOrderHistoryVisible() {
        // Implementation to check order history visibility
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isOnLoginPage() {
        // Implementation to verify login page
    }

    public void loginWithValidCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void enterCredentialsMultipleTimes(String username, String password, int times) {
        for (int i = 0; i < times; i++) {
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
        }
    }

    public boolean isLoginLimitMessageVisible() {
        // Implementation to verify login limit message visibility
    }

    public boolean isRecoveryAdviceVisible() {
        // Implementation to verify recovery advice visibility
    }

    public void clickLogoutButton() {
        // Implementation to click logout button
    }

    public boolean isLoggedOut() {
        // Implementation to verify logout status
    }

    public boolean isLogoutConfirmed() {
        // Implementation to verify logout confirmation
    }
}