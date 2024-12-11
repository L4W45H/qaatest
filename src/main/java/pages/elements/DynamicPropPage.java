package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class DynamicPropPage extends BasePage {
    String randId = "//p[@id]";
    String buttonAfter = "//*[@id='enableAfter']";
    String visAfter = "//*[@id='visibleAfter']";

    public DynamicPropPage(WebDriver driver) {
        super(driver);
    }

    public WebElement randId () {
        return driver.findElement(By.xpath(randId));
    }

    public WebElement buttonAfter () {
        return driver.findElement(By.xpath(buttonAfter));
    }

    public WebElement visAfter () {
        return driver.findElement(By.xpath(visAfter));
    }


}


