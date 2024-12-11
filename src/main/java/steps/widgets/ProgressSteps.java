package steps.widgets;

import org.openqa.selenium.WebDriver;
import pages.widgets.ProgressPage;
import pages.widgets.SliderPage;
import steps.BaseSteps;

public class ProgressSteps extends BaseSteps {
    ProgressPage progressPage;

    public ProgressSteps (WebDriver driver) {
        super(driver);
        this.progressPage = new ProgressPage(driver);
        selectMenu(progressPage,"Widgets","Progress Bar");
    }

    public ProgressSteps startButton () {progressPage.startButton().click();return this;}
    public ProgressSteps resetButton () {
        w8ElementPresence(progressPage.resetButton);
        w8ElementProgresBar(progressPage.resetButton);
        progressPage.resetButton().click(); return this;
    }
}
