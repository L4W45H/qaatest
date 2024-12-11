package steps.alerts;

import org.openqa.selenium.WebDriver;
import pages.alerts.ModalPage;
import pages.alerts.WindowsPage;
import steps.BaseSteps;

public class WindowsSteps extends BaseSteps {
    WindowsPage windowsPage;

    public WindowsSteps (WebDriver driver) {
        super(driver);
        this.windowsPage = new WindowsPage(driver);
        selectMenu(windowsPage, "Alerts", "Browser");
    }

    public WindowsSteps tabButton () {windowsPage.tabButton().click(); return this;}
    public WindowsSteps windowButton () {windowsPage.windowButton().click();return this;}
    public WindowsSteps messageWindowButton () {windowsPage.messageWindowButton().click();return this;}
}
