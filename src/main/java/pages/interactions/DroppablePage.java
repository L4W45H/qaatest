package pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class DroppablePage extends BasePage {
    String draggable = "//*[@id='draggable']";
    String droppable = "//*[@id='droppable']";



    public DroppablePage(WebDriver driver) {
        super(driver);
    }


    public WebElement draggable () {return driver.findElement(By.xpath(draggable));}
    public WebElement droppable () {return driver.findElement(By.xpath(droppable));}


}
