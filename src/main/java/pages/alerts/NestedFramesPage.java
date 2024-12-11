package pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class NestedFramesPage extends BasePage {
    String parentFrame = "//*[@id=\"frame1\"]";
    String childFrame = "/html/body/iframe";
    String childFrame2 = "//p";



    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement parentFrame () {return driver.findElement(By.xpath(parentFrame));}
    public WebElement childFrame () {return  driver.findElement(By.xpath(childFrame));}
    public WebElement childFrame2 () {return driver.findElement(By.xpath(childFrame2));}


}
