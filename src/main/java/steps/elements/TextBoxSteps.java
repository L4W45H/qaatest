package steps.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.TextBoxPage;
import steps.BaseSteps;

public class TextBoxSteps extends BaseSteps {
    TextBoxPage textBoxPage;


    public TextBoxSteps (WebDriver driver) {
        super(driver);
        this.textBoxPage = new TextBoxPage(driver);
        selectMenu(textBoxPage,"Elements","Text Box");
    }

    public TextBoxSteps setUserName (String text) {
        textBoxPage.getUserName().sendKeys(text);return this;
    }

    public TextBoxSteps setUserEmail (String text) {
        textBoxPage.getUserEmail().sendKeys(text);return this;
    }

    public TextBoxSteps setCurrentAddress (String text) {
        textBoxPage.getCurrentAddress().sendKeys(text);return this;
    }

    public TextBoxSteps setPermanentAddress (String text) {
        textBoxPage.getPermanentAddress().sendKeys(text);return this;
    }

    public TextBoxSteps clickSubmit () {
        textBoxPage.getSubmit().click();return this;
    }

    public TextBoxSteps displayOutput () {
        textBoxPage.getOutput().isDisplayed();return this;
    }

}
