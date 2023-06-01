package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void addToCart() {
        WebElement addButton = webDriver.findElement(By.cssSelector("button[class='sto-add2cart-add ebx-result-add2cart__full-button ebx-result-add2cart__button']"));
        addButton.click();
    }

    public void closeBanner(WebDriverWait wait) {
        WebElement closeBanner = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='sale-point-dialog__close icon-cross-thin']")));
        closeBanner.click();
    }
}

