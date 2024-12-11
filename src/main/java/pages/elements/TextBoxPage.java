package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class TextBoxPage extends BasePage {

    String userName = "#userName";
    String userEmail = "#userEmail";
    String currentAddress = "#currentAddress";
    String permanentAddress = "#permanentAddress";
    String submit ="#submit";
    String output = "#output";


    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserName () {
        return driver.findElement(By.cssSelector(userName));
    }

    public WebElement getUserEmail () {
        return driver.findElement(By.cssSelector(userEmail));
    }

    public WebElement getCurrentAddress () {
        return driver.findElement(By.cssSelector(currentAddress));
    }

    public WebElement getPermanentAddress () {
        return driver.findElement(By.cssSelector(permanentAddress));
    }

    public WebElement getSubmit () {
        return driver.findElement(By.cssSelector(submit));
    }
    public WebElement getOutput () {
        return driver.findElement(By.cssSelector(output));
    }


}

