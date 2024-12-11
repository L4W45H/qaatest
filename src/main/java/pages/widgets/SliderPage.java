package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class SliderPage extends BasePage {
    String slider = ".range-slider";

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement slider () {return driver.findElement(By.cssSelector(slider));}

}
