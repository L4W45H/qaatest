package steps.widgets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.interactions.DroppablePage;
import pages.widgets.SliderPage;
import steps.BaseSteps;

public class SliderSteps extends BaseSteps {
    SliderPage sliderPage;

    public SliderSteps (WebDriver driver) {
        super(driver);
        this.sliderPage = new SliderPage(driver);
        selectMenu(sliderPage,"Widgets","Slider");
    }
}
