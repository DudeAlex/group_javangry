import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class widgetsQATesting {
    private WebDriver webDriver;

    @BeforeTest
    private void createWebDriver() {
        webDriver = new ChromeDriver();
    }

    /*@AfterTest
    private void closeWebDriver() {
        webDriver.quit();
    }*/

    @Test
    void testSrollAndClickToWidgets() {
        webDriver.get("https://demoqa.com/");
        WebElement widgets = webDriver.findElement(By.className("card-body"));
        int deltaY = widgets.getRect().y;
        new Actions(webDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        webDriver.findElement(By.className("card-body")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    void testNotRegisteredUser() throws InterruptedException {
        webDriver.get("https://portal.311.nyc.gov/");
        Assert.assertEquals("Home  · NYC311", webDriver.getTitle());
        webDriver.findElement(By.xpath("//*[@class='btn btn-transparent']")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));

        WebElement textBox = webDriver.findElement(By.xpath("//*[@placeholder='Email Address']"));
        textBox.sendKeys("pasha@gmail.com");

        WebElement texBox2 = webDriver.findElement(By.xpath("//*[@placeholder='Password']"));
        texBox2.sendKeys("123400");

        webDriver.findElement(By.id("next")).click();
        Thread.sleep(250);
        String actual = webDriver.findElement(By.xpath("//div[@class='error pageLevel']//p[@role='alert']")).getText();
        Assert.assertEquals(actual, "We can't seem to find your account.");
    }

    @Test
    void testShoppingCardTest() throws InterruptedException {
        String numberOfItems = "5";
        String item = "Anchor Bracelet";
        webDriver.get("https://askomdch.com/");
        webDriver.findElement(By.xpath("//*[@id='menu-item-1227']")).click();

        webDriver.findElement(By.xpath("//*[text()='" + item + "']")).click();
        webDriver.findElement(By.xpath("//input[@type='number']")).clear();
        webDriver.findElement(By.xpath("//input[@type='number']")).sendKeys(numberOfItems);

        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        String cartData = webDriver.findElement(By.xpath("(//div[@id='ast-site-header-cart'])[1]//span")).getText();

        Assert.assertEquals(cartData, numberOfItems);
    }
}
