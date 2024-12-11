package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class DownloadUploadPage extends BasePage {

    String downloadButton = "#downloadButton";
    String uploadFile = "#uploadFile";
    String uploadedFilePath = "#uploadedFilePath";

    public DownloadUploadPage (WebDriver driver) {
        super(driver);
    }

    public WebElement downloadButton () {
        return driver.findElement(By.cssSelector(downloadButton));
    }
    public WebElement uploadFile () {
        return driver.findElement(By.cssSelector(uploadFile));
    }
    public WebElement uploadedFilePath () {
        return driver.findElement(By.cssSelector(uploadedFilePath));
    }

}
