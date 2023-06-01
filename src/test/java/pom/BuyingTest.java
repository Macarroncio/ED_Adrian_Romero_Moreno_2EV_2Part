package pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyingTest {
    private WebDriver webDriver;

    @Test
    public void buyingTest() {
        setupWebDriver();
        accessCarrefour();
        rejectCookies();

        ProductPage productPage = new ProductPage(webDriver);
        productPage.addToCart();

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        productPage.closeBanner(wait);

        CartPage cartPage = new CartPage(webDriver);
        String itemCount = cartPage.getItemCount();
        Assertions.assertEquals("1", itemCount, "Number of items in the cart is incorrect.");

        quitWebDriver();
    }

    private void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    private void accessCarrefour() {
        webDriver.get("https://www.carrefour.es");
    }

    private void rejectCookies() {
        WebElement cookieRejectButton = webDriver.findElement(By.id("onetrust-reject-all-handler"));
        cookieRejectButton.click();
    }

    private void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

