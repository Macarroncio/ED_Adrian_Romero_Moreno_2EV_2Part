import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListingTest {
    public static void main(String[] args) {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        // SETUP FOR ACCESSING THE WINE LIST
        webDriver.get("https://www.carrefour.es");

            // Reject cookies
        WebElement cookieRejectButton = webDriver.findElement(By.id("onetrust-reject-all-handler"));
        cookieRejectButton.click();

            // Open menu
        WebElement bodegaMenuTrigger = webDriver.findElement(By.cssSelector(".collage-menu__trigger.icon-menu-nav"));
        bodegaMenuTrigger.click();

            // Wait for Bodega option to be clickable and click it
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement bodegaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Bodega']")));
        bodegaOption.click();

            // Wait for Vinos Tintos option to be clickable and click it
        WebElement vinosTintosOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Vinos Tintos']")));
        vinosTintosOption.click();

            // Wait for Vinos Tintos Nacionales option to be clickable and click it
        WebElement vinosTintosNacionalesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Vinos Tintos Nacionales']")));
        vinosTintosNacionalesOption.click();

            // Find articles, assert the list has the 8 articles expected and print their text
        List<WebElement> articles = webDriver.findElements(By.tagName("article"));
        assert articles.size() == 8;
        for (WebElement article : articles) {
            System.out.println(article.getText());
            System.out.println("///////////////////////////");
        }


        // Close the browser
        //webDriver.quit();
    }
}

