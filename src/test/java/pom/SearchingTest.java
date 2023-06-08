package pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchingTest {
    private WebDriver webDriver;

    @Test
    public void searchTest() {
        setupWebDriver();
        accessCarrefour();
        rejectCookies();

        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.performSearch("pan");

        // Get the current URL
        String currentUrl = webDriver.getCurrentUrl();

        // Assert that the search input appears partially in the URL
        Assertions.assertTrue(currentUrl.contains("pan"), "Search input is not present in the URL.");

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
