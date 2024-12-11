package pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ModalPage extends BasePage  {
    String showSmallModal = "#showSmallModal";
    String closeSmallModal = "#closeSmallModal";
    String showLargeModal = "#showLargeModal";
    String closeLargeModal = "#closeLargeModal";
    String modalTitle = ".modal-title";


    public ModalPage(WebDriver driver) {
        super(driver);
    }

    public WebElement showSmallModal () {return driver.findElement(By.cssSelector(showSmallModal));}
    public WebElement closeSmallModal () {return driver.findElement(By.cssSelector(closeSmallModal));}
    public WebElement showLargeModal () {return driver.findElement(By.cssSelector(showLargeModal));}
    public WebElement closeLargeModal () {return driver.findElement(By.cssSelector(closeLargeModal));}
    public WebElement modalTitle () {return driver.findElement(By.cssSelector(modalTitle));}
}
