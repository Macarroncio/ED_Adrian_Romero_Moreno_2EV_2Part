import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchingTest {
    public static void main(String[] args) {


            // Set up Chrome driver
            System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();

            try {
                // Accessing carrefour
                webDriver.get("https://www.carrefour.es");

                // Reject cookies
                WebElement cookieRejectButton = webDriver.findElement(By.id("onetrust-reject-all-handler"));
                cookieRejectButton.click();

                //Locating and using the searchbar
                WebElement searchBar = webDriver.findElement(By.id("search-input"));
                searchBar.click();
                searchBar = webDriver.findElement(By.cssSelector("input[class='ebx-search-box__input ebx-search-box__input-query']"));

                String searchInput = "pan";
                searchBar.sendKeys(searchInput);
                searchBar.sendKeys(Keys.ENTER);

                // Get the current URL
                String currentUrl = webDriver.getCurrentUrl();

                // Assert that the search input appears partially in the URL
                Assertions.assertTrue(currentUrl.contains(searchInput), "Search input is not present in the URL.");

            } finally {
                // Quit the WebDriver
                //webDriver.quit();
            }
        }

}
