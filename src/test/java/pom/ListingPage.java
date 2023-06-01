package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListingPage {
    private WebDriver webDriver;

    public ListingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<WebElement> getArticles() {
        return webDriver.findElements(By.tagName("article"));
    }
}

