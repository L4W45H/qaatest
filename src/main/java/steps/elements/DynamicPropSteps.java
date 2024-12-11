package steps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.DynamicPropPage;
import pages.elements.WebTablesPage;
import steps.BaseSteps;

import java.time.Duration;

public class DynamicPropSteps extends BaseSteps {
   DynamicPropPage dynamicPropPage;

    public DynamicPropSteps(WebDriver driver) {
        super(driver);
        this.dynamicPropPage = new DynamicPropPage(driver);
        selectMenu(dynamicPropPage,"Elements","Dynamic Properties");
    }


    public String randId() {
        return dynamicPropPage.randId().getText();
    }
    public void buttonAfter() {
        w8ElementEnabled(dynamicPropPage.buttonAfter());
        dynamicPropPage.buttonAfter().click();
    }

    public void visAfter() {
        w8ElementClick(dynamicPropPage.visAfter());
        dynamicPropPage.visAfter().click();

    }








}
