package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ProgressPage extends BasePage {
    String startButton = "#startStopButton";
    public String resetButton = "//*[@id='resetButton']";

    public ProgressPage(WebDriver driver) {
        super(driver);
    }

    public WebElement startButton () {return driver.findElement(By.cssSelector(startButton));}
    public WebElement resetButton () {return driver.findElement(By.xpath(resetButton));}

}
