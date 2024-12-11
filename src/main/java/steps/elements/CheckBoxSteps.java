package steps.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.CheckBoxPage;
import pages.elements.TextBoxPage;
import steps.BaseSteps;

public class CheckBoxSteps extends BaseSteps {
    CheckBoxPage checkBoxPage;

    public CheckBoxSteps (WebDriver driver) {
        super(driver);
        this.checkBoxPage = new CheckBoxPage(driver);
        selectMenu(checkBoxPage,"Elements","Check Box");
    }

    public CheckBoxSteps home () {
        checkBoxPage.home().click(); return this;
    }

    public CheckBoxSteps documents () {
        checkBoxPage.documents().click(); return this;
    }

    public CheckBoxSteps office () {
        checkBoxPage.office().click(); return this;
    }

    public CheckBoxSteps classified () {
        checkBoxPage.classified().click(); return this;
    }

    public CheckBoxSteps general () {
        checkBoxPage.general().click(); return this;
    }

    public CheckBoxSteps textSuccess () {
        checkBoxPage.textSuccess().isDisplayed(); return this;
    }

    public String textSuccessGet1 () {
        return checkBoxPage.textSuccess1().getText();
    }
    public String textSuccessGet2 () {return checkBoxPage.textSuccess2().getText();}

}
