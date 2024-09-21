import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/app-root/div/div")
    private WebElement paymentPopup;

    @FindBy(xpath = "//*[@id=\"payment-sum\"]")
    private WebElement paymentSum;

    @FindBy(xpath = "//*[@id=\"payment-phone\"]")
    private WebElement paymentPhone;

    @FindBy(xpath = "//*[@id=\"payment-card-number\"]")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//*[@id=\"payment-card-expiry\"]")
    private WebElement cardExpiryInput;

    @FindBy(xpath = "//*[@id=\"payment-card-cvv\"]")
    private WebElement cardCvvInput;

    @FindBy(css = "img.payment-system-logo")
    private List<WebElement> paymentSystemLogos;

    public PaymentPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isPopupDisplayed() {
        return paymentPopup.isDisplayed();
    }

    public String getPaymentSum() {
        return paymentSum.getText();
    }

    public String getPaymentPhone() {
        return paymentPhone.getText();
    }

    public boolean isCardNumberInputDisplayed() {
        return cardNumberInput.isDisplayed();
    }

    public boolean isCardExpiryInputDisplayed() {
        return cardExpiryInput.isDisplayed();
    }

    public boolean isCardCvvInputDisplayed() {
        return cardCvvInput.isDisplayed();
    }

    public boolean arePaymentSystemLogosDisplayed() {
        for (WebElement logo : paymentSystemLogos) {
            if (!logo.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
