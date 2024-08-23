import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EP22PageClass {

    WebDriver driver;

    @FindBy(id='product-detail')
    WebElement productDetail;

    public EP22PageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewProductDetail() {
        productDetail.click();
    }
}