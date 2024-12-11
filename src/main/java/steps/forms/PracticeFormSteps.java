package steps.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.CheckBoxPage;
import pages.forms.PracticeFormPage;
import steps.BaseSteps;

import java.time.Duration;

public class PracticeFormSteps extends BaseSteps  {
   PracticeFormPage practiceFormPage;

    public PracticeFormSteps (WebDriver driver) {
        super(driver);
        this.practiceFormPage = new PracticeFormPage(driver);
        selectMenu(practiceFormPage,"Forms","Practice Form");
    }

    public PracticeFormSteps firstName (String text) {
        practiceFormPage.firstName().sendKeys(text);
        return this;
    }
    public PracticeFormSteps lastName (String text) {practiceFormPage.lastName().sendKeys(text); return this;}
    public PracticeFormSteps userEmail (String text) {practiceFormPage.userEmail().sendKeys(text); return this;}
    public PracticeFormSteps gender () {practiceFormPage.gender().click(); return this;}
    public PracticeFormSteps userNumber (String text) {practiceFormPage.userNumber().sendKeys(text); return this;}
    public PracticeFormSteps dateOfBirth () {practiceFormPage.dateOfBirth().click(); return this;}
    public PracticeFormSteps subject (String text) {practiceFormPage.subject().sendKeys(text); return this;}
    public PracticeFormSteps hobbyCheckBox1 () {practiceFormPage.hobbyCheckBox1().click(); return this;}
    public PracticeFormSteps hobbyCheckBox2 () {practiceFormPage.hobbyCheckBox2().click(); return this;}
    public PracticeFormSteps currentAddress (String text) {practiceFormPage.currentAddress().sendKeys(text); return this;}
    public PracticeFormSteps state () {practiceFormPage.state().click(); return this;}
    public PracticeFormSteps city () {practiceFormPage.city().click(); return this;}
    public PracticeFormSteps submit () {practiceFormPage.submit().click(); return this;}
    public PracticeFormSteps endForm () {practiceFormPage.endForm().isDisplayed(); return this;}
    public PracticeFormSteps dateSelect () {
        WebElement webelement = practiceFormPage.dateSelectMonth();
        Select select = new Select(webelement);
        select.selectByValue("5");
        webelement = practiceFormPage.dateSelectYear();
        select = new Select(webelement);
        select.selectByValue("1991");
        practiceFormPage.dateSelectDay().click();
        return this;
    }

    public PracticeFormSteps subjectSelect () {
        w8ElementPresence(practiceFormPage.autoComplete);
        practiceFormPage.autoComplete().click();
        return this;
    }

    public PracticeFormSteps stateSelect () {
        w8ElementPresence(practiceFormPage.stateSelect);
        practiceFormPage.stateSelect().click();
        return this;
    }

    public PracticeFormSteps citySelect () {
        w8ElementPresence(practiceFormPage.citySelect);
        practiceFormPage.citySelect();
        return this;
    }

    public PracticeFormSteps uploadPicture (String text) {
        practiceFormPage.uploadPicture().isDisplayed();
        practiceFormPage.uploadPicture().sendKeys(text);
        return this;
    }

}
