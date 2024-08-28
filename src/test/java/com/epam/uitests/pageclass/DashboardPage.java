import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    @FindBy(css = ".confirmation-message")
    private WebElement confirmationMessage;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}