import models.users.Comments;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class UiTests {
    FirefoxDriver driver;

    @BeforeMethod
    public void beforeM() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


    @Test(description = "")
    public void test1() {

        driver.get("https://demoqa.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.cssSelector(".card-body")).click();
        driver.findElement(By.cssSelector("#item-0")).click();
        js.executeScript("window.scrollBy(0,150)", "");
        driver.findElement(By.cssSelector("#userName")).sendKeys("testuser");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("testemail@gmail.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("testtext");
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("testtexttexttext");
        driver.findElement(By.cssSelector("#submit")).click();
        driver.findElement(By.cssSelector("#output")).isDisplayed();

    }

    @AfterMethod
    public void closeW () {

        driver.quit();

    }

}
