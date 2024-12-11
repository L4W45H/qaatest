package pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class AlertsPage extends BasePage {
    String alertButton = "#alertButton";
    String timerAlertButton = "#timerAlertButton";
    String confirmButton = "#confirmButton";
    String promtButton = "#promtButton";

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement alertButton () {return driver.findElement(By.cssSelector(alertButton));}
    public WebElement timerAlertButton () {return driver.findElement(By.cssSelector(timerAlertButton));}
    public WebElement confirmButton () {return driver.findElement(By.cssSelector(confirmButton));}
    public WebElement promtButton () {return driver.findElement(By.cssSelector(promtButton));}
}
