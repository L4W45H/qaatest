package steps.alerts;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.alerts.AlertsPage;
import pages.widgets.ProgressPage;
import steps.BaseSteps;

public class AlertsSteps extends BaseSteps {

    AlertsPage alertsPage;

    public AlertsSteps (WebDriver driver) {
        super(driver);
        this.alertsPage = new AlertsPage(driver);
        selectMenu(alertsPage,"Alerts","Alerts");
    }

    public void alertButton () {
       // Allure.step("click alert buton", () ->alertsPage.alertButton().click());
        alertsPage.alertButton().click();
    }
    public void timerAlertButton () {
        alertsPage.timerAlertButton().click();
        w8ElementAlert();
    }
    public void confirmButton () {alertsPage.confirmButton().click();}
    public void promtButton () {alertsPage.promtButton().click();}



}
