package steps.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.alerts.NestedFramesPage;
import pages.alerts.WindowsPage;
import steps.BaseSteps;

public class NestedFramesSteps extends BaseSteps {
    NestedFramesPage nestedFramesPage;

    public NestedFramesSteps (WebDriver driver) {
        super(driver);
        this.nestedFramesPage = new NestedFramesPage(driver);
        selectMenu(nestedFramesPage, "Alerts", "Nested");

    }

        public WebElement parentFrame () {return nestedFramesPage.parentFrame();}
        public NestedFramesSteps childFrame () { driver.switchTo().frame(nestedFramesPage.childFrame());return this;}
        public String childFrame2 () {return nestedFramesPage.childFrame2().getText();}





}
