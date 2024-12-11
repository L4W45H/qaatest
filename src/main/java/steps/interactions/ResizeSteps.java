package steps.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.interactions.DroppablePage;
import pages.interactions.ResizePage;
import steps.BaseSteps;

public class ResizeSteps extends BaseSteps {
    ResizePage resizePage;

    public ResizeSteps (WebDriver driver) {
        super(driver);
        this.resizePage = new ResizePage(driver);
        selectMenu(resizePage,"Interactions","Resizable");
    }


}
