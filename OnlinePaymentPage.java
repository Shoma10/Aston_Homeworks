import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlinePaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")
    private WebElement blockTitle;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]")
    private WebElement logosContainer;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")
    private WebElement detailsLink;

    @FindBy(xpath = "//*[@id=\"connection-phone\"]")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement amountInput;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getBlockTitle() {
        return blockTitle.getText().replaceAll("\\s+", " ").trim();
    }

    public boolean areLogosDisplayed() {
        return logosContainer.isDisplayed();
    }

    public void clickDetailsLink() {
        detailsLink.click();
    }

    public void fillPhoneInput(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void fillAmountInput(String amount) {
        amountInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void checkEmptyFieldLabels() {
        // Добавьте проверки для незаполненных полей
    }

    public PaymentPopup clickContinueAndGetPopup() {
        clickContinueButton();
        return new PaymentPopup(driver);
    }
}
