import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EP22StepDefinitions {

    WebDriver driver;

    @FindBy(id='add-to-cart-button')
    WebElement addToCartButton;

    public EP22StepDefinitions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public void checkItemInCart() {
        // Assert item is in cart
    }
}