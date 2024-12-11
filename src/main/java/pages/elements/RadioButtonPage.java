package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class RadioButtonPage extends BasePage {

    String yesCheckbox = "label[for='yesRadio']";
    String immCheckbox = "label[for='impressiveRadio']";
    String disCheckbox = "#noRadio";
    String textSuccess = ".text-success";

    public RadioButtonPage (WebDriver driver) {
        super(driver);
    }

    public WebElement yesCheckbox () {
        return driver.findElement(By.cssSelector(yesCheckbox));
    }

    public WebElement immCheckbox () {
        return driver.findElement(By.cssSelector(immCheckbox));
    }

    public WebElement disCheckbox () {
        return driver.findElement(By.cssSelector(disCheckbox));
    }

    public WebElement textSuccess () {
        return driver.findElement(By.cssSelector(textSuccess));
    }

}
