package driver;

import eNums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyPermission;

public class Driver {

    public FirefoxDriver fireFox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "/home/l4w45h-linux/Downloads");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }

    public ChromeDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");

        return new ChromeDriver();
    }

    public EdgeDriver edgeDriver() {
        System.setProperty("webdriver.edge.driver", "/home/l4w45h-linux/apps/edge_webdriver/msedgedriver");
        EdgeDriver edgeDriver = new EdgeDriver();
        return edgeDriver;
    }

    public WebDriver getWebDriver() {
        String browser;
        try {
            browser = properties().getProperty("webdriver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Browsers browsers = Browsers.valueOfBrowsers(browser);
        switch (browsers) {
            case CHROME -> {
                return chromeDriver();
            }
            case FIREFOX -> {
                return fireFox();
            }
            case EDGE -> {
                return edgeDriver();
            }
            case null, default -> throw new RuntimeException("not implemented exception");
        }

    }


    public Properties properties () throws IOException {
        Properties prop = new Properties();
        File configFile = new File("/home/l4w45h-linux/apps/idea-IC-243.21565.193/qaatest-main/src/main/resources/config.properties");
        InputStream stream = new FileInputStream(configFile);
        prop.load(stream);
        return prop;
    }

}
