package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CheckBoxPage extends BasePage {
    String home = "//*[text()='Home']/../../button";
    String documents = "//*[text()='Documents']/../../button";
    String office = "//*[text()='Office']/../../button";
    String classified = "//*[text()='Classified']";
    String general = "//*[text()='General']";
    String textSuccess = ".text-success";
    String textSuccess1 = "//div[@id='result']//span[@class='text-success'][1]";
    String textSuccess2 = "//div[@id='result']//span[@class='text-success'][2]";


    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public WebElement home () {
        return driver.findElement(By.xpath(home));
    }
    public WebElement documents () {
        return driver.findElement(By.xpath(documents));
    }
    public WebElement office () {
        return driver.findElement(By.xpath(office));
    }
    public WebElement classified () {
        return driver.findElement(By.xpath(classified));
    }
    public WebElement general () {
        return driver.findElement(By.xpath(general));
    }
    public WebElement textSuccess1 () {return driver.findElement(By.xpath(textSuccess1));}
    public WebElement textSuccess2 () {return driver.findElement(By.xpath(textSuccess2));}
    public WebElement textSuccess () {
        return driver.findElement(By.cssSelector(textSuccess));
    }

}
