import com.beust.ah.A;
import driver.Browser;
import driver.Driver;
import models.users.Comments;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v128.page.model.Frame;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;
import pages.alerts.AlertsPage;
import pages.alerts.NestedFramesPage;
import pages.elements.DynamicPropPage;
import pages.elements.RadioButtonPage;
import pages.elements.TextBoxPage;
import pages.elements.WebTablesPage;
import pages.interactions.DroppablePage;
import pages.interactions.ResizePage;
import pages.widgets.ProgressPage;
import pages.widgets.SliderPage;
import steps.alerts.AlertsSteps;
import steps.alerts.ModalSteps;
import steps.alerts.NestedFramesSteps;
import steps.alerts.WindowsSteps;
import steps.elements.*;
import steps.forms.PracticeFormSteps;
import steps.interactions.DroppableSteps;
import steps.interactions.ResizeSteps;
import steps.widgets.ProgressSteps;
import steps.widgets.SliderSteps;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static eNums.Endpoints.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class UiTests {
    WebDriver driver;
    File file;

    public static WebDriver getDriver() {
        String driverType = Browser.getDriverType();
        WebDriver driver = null;
        switch (driverType) {
            case "FIREROX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            case "CHROME":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser type: " + driverType);
        }
        return driver;
    }


    @BeforeMethod
    public void beforeM() {
        Driver browserDriver = new Driver();
        driver = browserDriver.getWebDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

    }


    @Test
    public void textForm() {
        TextBoxSteps textBoxSteps = new TextBoxSteps(driver);
        textBoxSteps.setUserName("testuser").setUserEmail("testemail@gmail.com").setCurrentAddress("testtext")
        .setPermanentAddress("testtexttexttext");
        WebElement elementToScroll = driver.findElement(By.cssSelector("#submit"));
        textBoxSteps.scrollToElement(elementToScroll);
        textBoxSteps.clickSubmit().displayOutput();

    }
    @Test
    public void yesCheckBox () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps(driver);
        radioButtonSteps.yesCheckbox();
        String text = radioButtonSteps.textSuccess();
        Assert.assertEquals(text, "Yes" );
        radioButtonSteps.textSuccess();

    }

    @Test
    public void immCheckBox () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps(driver);
        radioButtonSteps.immCheckbox();
        String text = radioButtonSteps.textSuccess();
        Assert.assertEquals(text, "Impressive" );
        radioButtonSteps.textSuccess();
    }

    @Test
    public void disabledCheckBox () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps(driver);
        boolean isDisabled = radioButtonSteps.disCheckbox();
        Assert.assertTrue(isDisabled, "Checkbox is not disabled");
    }

    @Test
    public void download () {
        DownloadUploadSteps downloadUploadSteps = new DownloadUploadSteps(driver);
        String fileName = downloadUploadSteps.downloadButton("download");
        downloadUploadSteps.downloadButton();
         file = new File("/home/l4w45h-linux/Downloads/"+fileName);
        Assert.assertTrue(file.exists());
    }

    @Test ( dependsOnMethods = {"download"})
    public void upload () {
        DownloadUploadSteps downloadUploadSteps = new DownloadUploadSteps(driver);
        downloadUploadSteps.uploadFile().uploadFile(file.getAbsolutePath()).uploadedFilePath();
        file.delete();
    }

    @Test
    public void checkBoxTree () {
        CheckBoxSteps checkBoxSteps = new CheckBoxSteps(driver);
        checkBoxSteps.home().documents().office().classified().general();
        String text1 = checkBoxSteps.textSuccessGet1();
        Assert.assertEquals(text1, "classified");
        String text2 = checkBoxSteps.textSuccessGet2();
        Assert.assertEquals(text2, "general");
        checkBoxSteps.textSuccess();
    }

    @Test
    public void table () {
        WebTablesSteps webTablesSteps = new WebTablesSteps(driver);
        String oldString = webTablesSteps.verify();
        webTablesSteps.edit().firstName("text").lastName("texttext").userEmail("text@text.com")
                .age("45").salary("16000").department("text").submit();
        String newString = webTablesSteps.verify();
        assertNotEquals(oldString, newString);
    }
    @Test
    public void table2 () {
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        WebTablesSteps webTablesSteps = new WebTablesSteps(driver);
        String oldString = webTablesSteps.verify();
        webTablesSteps.edit();
      List <WebElement> table = webTablesPage.userForm();
      List <String> data = List.of("test1","testtest","test@test.com","23", "12312", "test");
   //   for (int i = 0; i < table.size(); i++) {
    //      table.get(i).clear();
   //       table.get(i).sendKeys(data.get(i));
    //  }
        IntStream.range(0, table.size()).forEach(i->{
            table.get(i).clear();
            table.get(i).sendKeys(data.get(i));
        });
        webTablesSteps.submit();
        String newString = webTablesSteps.verify();
        assertNotEquals(oldString, newString);
    }

    @Test
    public void dynamicProp ()  {
        DynamicPropSteps dynamicPropSteps = new DynamicPropSteps(driver);
        dynamicPropSteps.randId();
        dynamicPropSteps.buttonAfter();
        dynamicPropSteps.visAfter();

    }

    @Test
    public void pracriceForm () {
        PracticeFormSteps practiceFormSteps = new PracticeFormSteps(driver);
        practiceFormSteps.firstName("firstName").lastName("lastName").userEmail("user@email.com").gender().userNumber("0951234567");
        WebElement elementToScroll = driver.findElement(By.cssSelector("#dateOfBirthInput"));
        practiceFormSteps.scrollToElement(elementToScroll);
        practiceFormSteps.dateOfBirth()
       .dateSelect()
       .subject("A").subjectSelect().hobbyCheckBox1().hobbyCheckBox2()
       .currentAddress("Adress street 123 city").state().stateSelect().city().citySelect();
       file = new File("/home/l4w45h-linux/Downloads/test.png");
       Assert.assertTrue(file.exists());
       practiceFormSteps.uploadPicture(file.getAbsolutePath());
       practiceFormSteps.submit()
       .endForm();
    }

    @Test
    public void dragNdrop () {
        DroppablePage droppablePage = new DroppablePage(driver);
        DroppableSteps droppableSteps = new DroppableSteps(driver);
        droppableSteps.dragNdrop(droppablePage.draggable(), droppablePage.droppable());
    }

    @Test
    public void resize () {
        ResizePage resizePage = new ResizePage(driver);
        ResizeSteps resizeSteps = new ResizeSteps(driver);
        WebElement drag = resizePage.resize1();
        resizeSteps.dragNdrop(drag,100,20);
        WebElement elementToScroll = driver.findElement(By.xpath("//*[contains(text(),'Book Store')]/parent::div"));
        resizeSteps.scrollToElement(elementToScroll);
        WebElement drag2 = resizePage.resize2();
        resizeSteps.dragNdrop(drag2,-100,-20);
    }

    @Test
    public void slider () {
        SliderPage sliderPage = new SliderPage(driver);
        SliderSteps sliderSteps = new SliderSteps(driver);
        WebElement drag = sliderPage.slider();
        sliderSteps.dragNdrop(drag,100,0);
    }

    @Test
    public void progressBar () {
        ProgressSteps progressSteps = new ProgressSteps(driver);
        progressSteps.startButton().resetButton();
    }

    @Test
        public void alerts () {
        AlertsSteps alertsSteps = new AlertsSteps(driver);
        alertsSteps.alertButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alertsSteps.timerAlertButton();
        alert.accept();
        alertsSteps.confirmButton();
        alert.dismiss();
        alertsSteps.promtButton();
        alert.sendKeys("name");
        alert.accept();
    }

    @Test
    public void modals () {
        ModalSteps modalSteps = new ModalSteps(driver);
        modalSteps.showSmallModal().modalTitle().closeSmallModal().showLargeModal().modalTitle().closeLargeModal();

    }

    @Test
    public void windows () {
        WindowsSteps windowsSteps = new WindowsSteps(driver);
        windowsSteps.tabButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        windowsSteps.windowButton();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.close();
        driver.switchTo().window(windows.get(0));
        windowsSteps.messageWindowButton();

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalWindow);

        }

        @Test
        public void nestedFrames () {
             NestedFramesSteps nestedFramesSteps = new NestedFramesSteps(driver);
             driver.switchTo().frame(nestedFramesSteps.parentFrame());
             String getText = nestedFramesSteps.childFrame().childFrame2();
             System.out.println(getText);

    }





        @Test
        public void test1 () {
            System.out.println(valueOfLabel(POSTS));
        }




    @AfterMethod
    public void closeW () {
        driver.quit();

    }

}
