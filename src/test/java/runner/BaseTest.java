package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public abstract class BaseTest {

    private WebDriver driver;
    private final static String URL = "https://www.selenium.dev/selenium/web/";

    @BeforeMethod
    protected void beforeMethod() {
        try {
            startDriver();
        } catch (Exception e) {
            closeDriver();
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    protected void afterMethod() {
        closeDriver();
    }

    private void closeDriver() {
        if (driver != null) {
            driver.quit();

            driver = null;
        }
    }

    private void startDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-infobars");

        chromeOptions.addExtensions(new File("./Extentions/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_21_0_0.crx"));
        driver = new ChromeDriver(chromeOptions);
    }

}
