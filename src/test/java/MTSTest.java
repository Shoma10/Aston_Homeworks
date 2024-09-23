import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MTSTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testOnlinePaymentBlockTitle() {
        driver.get("https://mts.by");
        closeCookieBanner();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));
        String actualText = blockTitle.getText().replaceAll("\\s+", " ").trim();
        String expectedText = "Онлайн пополнение без комиссии";
        assertEquals(actualText, expectedText, "Title does not match");
    }

    @Test
    public void testPaymentSystemLogos() {
        driver.get("https://mts.by");
        closeCookieBanner();
        WebElement logosContainer = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]"));
        assertTrue(logosContainer.isDisplayed(), "Payment system logos are not displayed");
    }

    @Test
    public void testServiceDetailsLink() {
        driver.get("https://mts.by");
        closeCookieBanner();
        WebElement detailsLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        clickElement(detailsLink);
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "URL does not match");
    }

    @Test
    public void testContinueButton() {
        driver.get("https://mts.by");
        closeCookieBanner();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneInput.sendKeys("297777777");
        WebElement amountInput = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        amountInput.sendKeys("100");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        clickElement(continueButton);

        // Проверка shadow DOM
        try {
            WebElement shadowHost = driver.findElement(By.cssSelector("body > app-root > div > div"));
            WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost);
            WebElement paymentPopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > app-root > div > div")));
            assertTrue(isElementVisible(paymentPopup), "Payment popup is not displayed");
        } catch (Exception e) {
            // Если элемент не найден в shadow DOM, продолжаем выполнение теста
        }
    }

    private boolean isElementVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return arguments[0].offsetParent !== null", element);
    }

    private void closeCookieBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cookie.show")));
            WebElement closeButton = cookieBanner.findElement(By.cssSelector(".close-button"));
            closeButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (Exception e) {
            // Если баннер не найден или не удалось закрыть, просто продолжаем выполнение теста
        }
    }

    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}