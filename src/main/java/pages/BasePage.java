package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebDriver driver;
    String menu = "//*[contains(text(),'%s')]/parent::div";
    String secMenu = "//span[contains(text(),'%s')]";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menu (String option) {
       return driver.findElement(By.xpath(String.format(menu,option)));
    }

    public WebElement secMenu (String option) {
        return driver.findElement(By.xpath(String.format(secMenu,option)));
    }



}
