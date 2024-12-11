package pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class WindowsPage extends BasePage {
    String tabButton = "#tabButton";
    String windowButton = "#windowButton";
    String messageWindowButton = "#messageWindowButton";

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement tabButton () {return driver.findElement(By.cssSelector(tabButton));}
    public WebElement windowButton () {return driver.findElement(By.cssSelector(windowButton));}
    public WebElement messageWindowButton () {return driver.findElement(By.cssSelector(messageWindowButton));}
}
