package steps.alerts;

import org.openqa.selenium.WebDriver;
import pages.alerts.AlertsPage;
import pages.alerts.ModalPage;
import steps.BaseSteps;

public class ModalSteps extends BaseSteps {
    ModalPage modalPage;

    public ModalSteps (WebDriver driver) {
        super(driver);
        this.modalPage = new ModalPage(driver);
        selectMenu(modalPage, "Alerts", "Modal");

    }

        public ModalSteps showSmallModal () {modalPage.showSmallModal().click();return this;}
        public ModalSteps closeSmallModal () {modalPage.closeSmallModal().click();return this;}
        public ModalSteps showLargeModal () {modalPage.showLargeModal().click();return this;}
        public ModalSteps closeLargeModal () {modalPage.closeLargeModal().click();return this;}
        public ModalSteps modalTitle () {modalPage.modalTitle().isDisplayed();return this;}


}
