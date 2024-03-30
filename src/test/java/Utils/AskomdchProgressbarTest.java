package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AskomdchProgressbarTest {
    private WebDriver driver;
    final static String URL_SHOP = "https://askomdch.com/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL_SHOP);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void testProgressBar() throws InterruptedException {
        driver.findElement(By.xpath("//li[@id='menu-item-1228']")).click();
        WebElement progressLeft = driver.findElement(By.xpath("//*[@id='woocommerce_price_filter-3']/form/div/div/span[1]"));
        progressBarMove(Keys.ARROW_RIGHT, progressLeft);
        WebElement progressRight = driver.findElement(By.xpath("//*[@id='woocommerce_price_filter-3']/form/div/div[1]/span[2]"));
        progressBarMove(Keys.ARROW_LEFT, progressRight);
        driver.findElement(By.xpath("//*[@class='button']")).click();
        String expectedLowPrice = driver.findElement(By.xpath("//*[@id='woocommerce_price_filter-3']//div[2]/div[1]/span[1]")).getText();

        Assert.assertEquals(expectedLowPrice, "$50");
        Thread.sleep(10000);
    }

    private void progressBarMove(Keys arrow, WebElement element) {
        for (int i = 0; i < 3; i++) {
            element.sendKeys(arrow);
        }
    }
}
