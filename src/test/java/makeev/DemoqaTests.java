package makeev;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class DemoqaTests {

    private final static String URL = "https://demoqa.com/";

    private WebDriver webDriver;

    @BeforeTest
    private void createWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-infobars");

        chromeOptions.addExtensions(new File("./Extentions/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_21_0_0.crx"));
        webDriver = new ChromeDriver(chromeOptions);
    }

    @AfterTest
    private void closeWebDriver() {
        webDriver.quit();
    }

    /*@Test
    public void joinNowButtonTest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://demoqa.com/");

        // открывается на новой вкладке. найти как искать в новой вкдадке!
        //WebElement joinNowButton = driver.findElement(By.xpath("//a[href ='https://www.toolqa.com/selenium-training']"));
        WebElement joinNowButton = driver.findElement(By.xpath("//a[href='https://www.toolsqa.com/selenium-training/']"));
        joinNowButton.click();


        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.toolsqa.com/selenium-training/";

        Assert.assertEquals(currentUrl, expectedUrl);

        driver.quit();

    }*/


    @Test
    public void textBoxTest() throws InterruptedException {

        String expectedResult = "Name:John Dou Email:jd@example.com Current Address :Us, Atlanta";

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("disable-popup-blocking");
//        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("incognito");

//        chromeOptions.addExtensions(new File("./Extentions/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_21_0_0.crx"));
//        WebDriver driver = new ChromeDriver(chromeOptions);

        //WebDriver driver = new ChromeDriver();

        Thread.sleep(1000);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        webDriver.get("https://demoqa.com/");
        //driver.findElement(By.xpath("//iframe[contains(@id,'google_ads_iframe')]/div[@role='button']")).click();

        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text()='Text Box']")).click();
        webDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys("John Dou");
        webDriver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("jd@example.com");
        webDriver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Us, Atlanta");
        //driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Us, Somewhere");
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();

        List<WebElement> list = webDriver.findElements(By.xpath("//p[@class='mb-1']"));
        StringBuilder resultActual = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            WebElement webElement = list.get(i);
            if (i < list.size() - 1) {
                resultActual.append(webElement.getText()).append(" ");
            } else {
                resultActual.append(webElement.getText());
            }
        }
        Assert.assertEquals(resultActual.toString(), expectedResult);
        //driver.quit();
    }

    @Test
    public void addingInfoToWebTablesTest() throws InterruptedException {

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("disable-popup-blocking");
//        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("incognito");
        //chromeOptions.addArguments("headless");

//        chromeOptions.addExtensions(new File("./Extentions/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_21_0_0.crx"));
//        WebDriver driver = new ChromeDriver(chromeOptions);

        Thread.sleep(1000);

        //WebDriver driver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        webDriver.get("https://demoqa.com/");

        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text()='Web Tables']")).click();
        webDriver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        WebElement form = webDriver.findElement(By.xpath("//form[@id='userForm']"));

        form.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        form.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Dou");
        form.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("jm@example.com");
        form.findElement(By.xpath("//input[@id='age']")).sendKeys("27");
        form.findElement(By.xpath("//input[@id='salary']")).sendKeys("1500");
        form.findElement(By.xpath("//input[@id='department']")).sendKeys("Marketing");
        form.findElement(By.xpath("//button[@id='submit']")).click();

        List<WebElement> list = form.findElements(By.xpath("//div[@class='rt-table']//div[div[text()='John' and @class='rt-td']]"));
        StringBuilder resultActual = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            WebElement webElement = list.get(i);
            if (i < list.size() - 1) {
                resultActual.append(webElement.getText()).append(" ");
            } else {
                resultActual.append(webElement.getText());
            }
        }
        String expectedResult = "John\n" +
                "Dou\n" +
                "27\n" +
                "jm@example.com\n" +
                "1500\n" +
                "Marketing";
        Assert.assertEquals(resultActual.toString(), expectedResult);
    }

}


