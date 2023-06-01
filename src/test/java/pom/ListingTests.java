package pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListingTests {
    private WebDriver webDriver;

    @Test
    public void listingTest() {
        setupWebDriver();
        accessCarrefour();
        rejectCookies();

        MenuPage menuPage = new MenuPage(webDriver);
        menuPage.openBodegaMenu();
        menuPage.selectVinosTintos();
        menuPage.selectVinosTintosNacionales();

        ListingPage listingPage = new ListingPage(webDriver);
        List<WebElement> articles = listingPage.getArticles();
        Assertions.assertEquals(8, articles.size(), "Number of articles is incorrect.");

        for (WebElement article : articles) {
            System.out.println(article.getText());
            System.out.println("///////////////////////////");
        }

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

