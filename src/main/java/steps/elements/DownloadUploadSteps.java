package steps.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.DownloadUploadPage;
import pages.elements.RadioButtonPage;
import steps.BaseSteps;

public class DownloadUploadSteps extends BaseSteps {
    DownloadUploadPage downloadUploadPage;


    public DownloadUploadSteps(WebDriver driver) {

        super(driver);
        this.downloadUploadPage = new DownloadUploadPage(driver);
        selectMenu(downloadUploadPage,"Elements","Upload");

    }

    public DownloadUploadSteps downloadButton() {

        downloadUploadPage.downloadButton().click();return this;
    }

    public DownloadUploadSteps uploadFile(String text) {

        downloadUploadPage.uploadFile().sendKeys(text);return this;

    }

    public DownloadUploadSteps uploadFile() {
        downloadUploadPage.uploadFile().isDisplayed();return this;
    }
    public DownloadUploadSteps uploadedFilePath() {
        downloadUploadPage.uploadedFilePath().isDisplayed();return this;
    }

    public String downloadButton(String text) {

        return downloadUploadPage.downloadButton().getAttribute(text);

    }

}

