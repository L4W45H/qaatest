package steps.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.forms.PracticeFormPage;
import pages.interactions.DroppablePage;
import steps.BaseSteps;

public class DroppableSteps extends BaseSteps {
   DroppablePage droppablePage;

    public DroppableSteps (WebDriver driver) {
        super(driver);
        this.droppablePage = new DroppablePage(driver);
        selectMenu(droppablePage,"Interactions","Droppable");
    }


}
