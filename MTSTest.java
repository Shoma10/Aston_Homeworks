import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MTSTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Укажите путь к драйверу ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testOnlinePaymentBlockTitle() {
        driver.get("https://mts.by");
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        String actualText = onlinePaymentPage.getBlockTitle();
        String expectedText = "Онлайн пополнение без комиссии";
        assertEquals(actualText, expectedText, "Title does not match");
    }

    @Test
    public void testPaymentSystemLogos() {
        driver.get("https://mts.by");
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        assertTrue(onlinePaymentPage.areLogosDisplayed(), "Payment system logos are not displayed");
    }

    @Test
    public void testServiceDetailsLink() {
        driver.get("https://mts.by");
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.clickDetailsLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "URL does not match");
    }

    @Test
    public void testContinueButton() {
        driver.get("https://mts.by");
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.fillPhoneInput("297777777");
        onlinePaymentPage.fillAmountInput("100");
        PaymentPopup paymentPopup = onlinePaymentPage.clickContinueAndGetPopup();

        assertTrue(paymentPopup.isPopupDisplayed(), "Payment popup is not displayed");
        assertEquals(paymentPopup.getPaymentSum(), "100", "Payment sum does not match");
        assertEquals(paymentPopup.getPaymentPhone(), "297777777", "Payment phone does not match");
        assertTrue(paymentPopup.isCardNumberInputDisplayed(), "Card number input is not displayed");
        assertTrue(paymentPopup.isCardExpiryInputDisplayed(), "Card expiry input is not displayed");
        assertTrue(paymentPopup.isCardCvvInputDisplayed(), "Card CVV input is not displayed");
        assertTrue(paymentPopup.arePaymentSystemLogosDisplayed(), "Payment system logos are not displayed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
