import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyingTest {
    @Test
    public void searchTest() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        try {
            // Accessing carrefour
            webDriver.get("https://www.carrefour.es");

            // Reject cookies
            WebElement cookieRejectButton = webDriver.findElement(By.id("onetrust-reject-all-handler"));
            cookieRejectButton.click();

            //Locating and buying an element
            WebElement addButton = webDriver.findElement(By.cssSelector("button[class='sto-add2cart-add ebx-result-add2cart__full-button ebx-result-add2cart__button']"));
            addButton.click();
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            WebElement closeBanner = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='sale-point-dialog__close icon-cross-thin']")));
            closeBanner.click();

            //Testing that an item has been added to the chart
            WebElement count = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='cart-header__count']")));
            String number = count.getText();
            assert number.equals("1");
        } finally {
            // Quit the WebDriver
            webDriver.quit();

        }
    }
}