package steps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.RadioButtonPage;
import pages.elements.TextBoxPage;
import steps.BaseSteps;

public class RadioButtonSteps extends BaseSteps {

    RadioButtonPage radioButtonPage;

    public RadioButtonSteps (WebDriver driver) {
        super(driver);
        this.radioButtonPage = new RadioButtonPage(driver);
        selectMenu(radioButtonPage,"Elements","Radio");
    }

    public void yesCheckbox () {
        radioButtonPage.yesCheckbox().click();
    }

    public boolean disCheckbox () {
        return !radioButtonPage.disCheckbox().isEnabled();
    }

    public void immCheckbox () {
        radioButtonPage.immCheckbox().click();
    }

    public String textSuccess () {
        return radioButtonPage.textSuccess().getText();
    }



}
