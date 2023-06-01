package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public MenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    public void openBodegaMenu() {
        WebElement bodegaMenuTrigger = webDriver.findElement(By.cssSelector(".collage-menu__trigger.icon-menu-nav"));
        bodegaMenuTrigger.click();
    }

    public void selectVinosTintos() {
        WebElement vinosTintosOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Vinos Tintos']")));
        vinosTintosOption.click();
    }

    public void selectVinosTintosNacionales() {
        WebElement vinosTintosNacionalesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Vinos Tintos Nacionales']")));
        vinosTintosNacionalesOption.click();
    }
}
