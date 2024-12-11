package pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class PracticeFormPage extends BasePage {
    String firstName = "//*[@id='firstName']";
    String lastName = "//*[@id='lastName']";
    String userEmail = "//*[@id='userEmail']";
    String gender = "//*[@for='gender-radio-2']";
    String userNumber = "//*[@id='userNumber']";
    String dateOfBirth = "//*[@id='dateOfBirthInput']";
    String subject = "//*[@id='subjectsInput']";
    public String autoComplete = "//*[@id='react-select-2-option-2']";
    String hobbyCheckBox1 = "//*[@for='hobbies-checkbox-2']";
    String hobbyCheckBox2 = "//*[@for='hobbies-checkbox-3']";
    String currentAddress = "//*[@id='currentAddress']";
    String state = "//*[@id='state']";
    public String stateSelect = "//*[@id='react-select-3-option-2']";
    String city = "//*[@id='city']";
    public String citySelect = "//*[@id='react-select-4-option-1']";
    String submit = "//*[@id='submit']";
    String endForm = "//*[@class='modal-body']";
    String dateSelectMonth = "react-datepicker__month-select";
    String dateSelectYear = "react-datepicker__year-select";
    String dateSelectDay = "//*[contains ( @class, 'react-datepicker__day--020')]";
    String uploadPicture = "#uploadPicture";

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName () {return driver.findElement(By.xpath(firstName));}
    public WebElement lastName () {return driver.findElement(By.xpath(lastName));}
    public WebElement userEmail () {return driver.findElement(By.xpath(userEmail));}
    public WebElement gender () {return driver.findElement(By.xpath(gender));}
    public WebElement userNumber () {return driver.findElement(By.xpath(userNumber));}
    public WebElement dateOfBirth () {return driver.findElement(By.xpath(dateOfBirth));}
    public WebElement subject () {return driver.findElement(By.xpath(subject));}
    public WebElement autoComplete () {return driver.findElement(By.xpath(autoComplete));}
    public WebElement hobbyCheckBox1 () {return driver.findElement(By.xpath(hobbyCheckBox1));}
    public WebElement hobbyCheckBox2 () {return driver.findElement(By.xpath(hobbyCheckBox2));}
    public WebElement currentAddress () {return driver.findElement(By.xpath(currentAddress));}
    public WebElement state () {return driver.findElement(By.xpath(state));}
    public WebElement stateSelect () {return driver.findElement(By.xpath(stateSelect));}
    public WebElement city () {return driver.findElement(By.xpath(city));}
    public WebElement citySelect () {return driver.findElement(By.xpath(citySelect));}
    public WebElement submit () {return driver.findElement(By.xpath(submit));}
    public WebElement endForm () {return driver.findElement(By.xpath(endForm));}
    public WebElement dateSelectMonth () {return driver.findElement(By.className(dateSelectMonth));}
    public WebElement dateSelectYear () {return driver.findElement(By.className(dateSelectYear));}
    public WebElement dateSelectDay () {return driver.findElement(By.xpath(dateSelectDay));}
    public WebElement uploadPicture () {return driver.findElement(By.cssSelector(uploadPicture));}

}
