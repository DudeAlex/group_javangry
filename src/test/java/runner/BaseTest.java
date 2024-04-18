package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private final static String URL = "https://www.selenium.dev/selenium/web/";

    @BeforeMethod
    protected void beforeMethod() {
        try {
            startDriver();
            getWeb();
        } catch (Exception e) {
            closeDriver();
            throw new RuntimeException(e);
        }
    }



    static String getUrl() {
        return URL;
    }@AfterMethod
    protected void afterMethod() {
        closeDriver();
    }

    public static void get(WebDriver driver) {
        driver.get(getUrl());
    }

    private void getWeb() {
        get(driver);
    }


    private void closeDriver() {
        if (driver != null) {
            driver.quit();

            driver = null;
        }
    }

    private WebDriver startDriver() {
        driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1920,1080");
        //chromeOptions.addArguments("disable-popup-blocking");
        //chromeOptions.addArguments("disable-infobars");

        //chromeOptions.addExtensions(new File("./Extentions/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_21_0_0.crx"));

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
