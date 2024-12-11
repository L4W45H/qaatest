package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class WebTablesPage extends BasePage {
    String edit = "//span[@id='edit-record-3']";
    String firstName = "//input[@id='firstName']";
    String lastName = "//input[@id='firstName']";
    String userEmail = "//input[@id='userEmail']";
    String age = "//input[@id='age']";
    String salary = "//input[@id='salary']";
    String department = "//input[@id='department']";
    String submit = "//button[@id='submit']";
    String verify = "(//div[@class='rt-tr -odd'])[2]";
    String userForm = "//*[@id='userForm']//input";

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement edit () {
        return driver.findElement(By.xpath(edit));
    }
    public WebElement firstName () {
        return driver.findElement(By.xpath(firstName));
    }
    public WebElement lastName () {
        return driver.findElement(By.xpath(lastName));
    }
    public WebElement userEmail () {
        return driver.findElement(By.xpath(userEmail));
    }
    public WebElement age () {
        return driver.findElement(By.xpath(age));
    }
    public WebElement salary () {
        return driver.findElement(By.xpath(salary));
    }
    public WebElement department () {
        return driver.findElement(By.xpath(department));
    }
    public WebElement submit () {
        return driver.findElement(By.xpath(submit));
    }
    public WebElement verify () {
        return driver.findElement(By.xpath(verify));
    }

    public List <WebElement> userForm () {
        return driver.findElements(By.xpath(userForm));
    }

}
