package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getItemCount() {
        WebElement count = webDriver.findElement(By.cssSelector("span[class='cart-header__count']"));
        return count.getText();
    }
}

