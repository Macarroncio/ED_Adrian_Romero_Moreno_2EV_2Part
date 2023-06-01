package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void performSearch(String searchInput) {
        WebElement searchBar = webDriver.findElement(By.id("search-input"));
        searchBar.click();
        searchBar = webDriver.findElement(By.cssSelector("input[class='ebx-search-box__input ebx-search-box__input-query']"));

        searchBar.sendKeys(searchInput);
        searchBar.sendKeys(Keys.ENTER);
    }
}
