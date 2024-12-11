package pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ResizePage extends BasePage {

     String resize1 = "//*[@class='react-resizable-handle react-resizable-handle-se']";
     String resize2 = "(//*[@class='react-resizable-handle react-resizable-handle-se'])[2]";

    public ResizePage(WebDriver driver) {
        super(driver);
    }

    public WebElement resize1 () {return driver.findElement(By.xpath(resize1));}
    public WebElement resize2 () {return driver.findElement(By.xpath(resize2));}


}
