package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;


public class BaseSteps {
    public WebDriver driver;

    public BaseSteps (WebDriver driver) {
        this.driver = driver;


    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectMenu (BasePage basePage,String baseMenu, String  secMenu) {
        WebElement elementToScroll =  basePage.menu("Forms");
        scrollToElement(elementToScroll);
        basePage.menu(baseMenu).click();
        basePage.secMenu(secMenu).click();
    }

    public void w8ElementEnabled (WebElement wElement) {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(5200));
        w8.until(element -> wElement.isEnabled());
    }

    public void w8ElementClick (WebElement wElement) {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(5200));
        w8.until(ExpectedConditions.elementToBeClickable(wElement));
    }

    public void w8ElementPresence (String wElement) {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(15200));
        w8.until(ExpectedConditions.presenceOfElementLocated((By.xpath(wElement))));
    }

    public void w8ElementProgres1 (String wElement) {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(5200));
        WebElement progressBar = driver.findElement(By.cssSelector("#progress-bar"));
        w8.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));
    }

    public void w8ElementProgresBar (String wElement) {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(15200));
        WebElement button = driver.findElement(By.className("btn-primary"));
        w8.until(ExpectedConditions.attributeToBe(button, "id", "resetButton"));
    }

    public void w8ElementAlert () {
        WebDriverWait w8 = new WebDriverWait(driver, Duration.ofMillis(5200));
        w8.until(ExpectedConditions.alertIsPresent());
    }

    public void dragNdrop (WebElement drag,int x, int y) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(drag, x, y);
        action.perform();
    }

    public void dragNdrop (WebElement webElement1, WebElement webElemet2) {
        Actions action = new Actions(driver);
        action.dragAndDrop(webElement1, webElemet2).build().perform();
    }



}
