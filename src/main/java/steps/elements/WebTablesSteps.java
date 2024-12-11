package steps.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.CheckBoxPage;
import pages.elements.WebTablesPage;
import steps.BaseSteps;

public class WebTablesSteps extends BaseSteps {
    WebTablesPage webTablesPage;

    public WebTablesSteps(WebDriver driver) {
        super(driver);
        this.webTablesPage = new WebTablesPage(driver);
        selectMenu(webTablesPage,"Elements","Web Tables");
    }


    public WebTablesSteps edit() {
        webTablesPage.edit().click();return this ;
    }

    public WebTablesSteps firstName(String text) {
        webTablesPage.firstName().clear();
        webTablesPage.firstName().sendKeys(text);return this ;
    }

    public WebTablesSteps lastName(String text) {
        webTablesPage.lastName().clear();
        webTablesPage.lastName().sendKeys(text);return this ;
    }

    public WebTablesSteps userEmail(String text) {
        webTablesPage.userEmail().clear();
        webTablesPage.userEmail().sendKeys(text);return this ;
    }

    public WebTablesSteps age(String text) {
        webTablesPage.age().clear();
        webTablesPage.age().sendKeys(text);return this ;
    }

    public WebTablesSteps salary(String text) {
        webTablesPage.salary().clear();
        webTablesPage.salary().sendKeys(text); return this ;
    }

    public WebTablesSteps department(String text) {
        webTablesPage.department().clear();
        webTablesPage.department().sendKeys(text); return this ;
    }

    public WebTablesSteps submit() {
        webTablesPage.submit().click(); return this ;
    }

    public String verify() {
       return webTablesPage.verify().getText();
    }


}
