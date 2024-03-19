import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQATesting {
    private WebDriver webDriver;

    @BeforeTest
    private void createWebdriver() {
        webDriver = new ChromeDriver();
    }

    @AfterTest
    private void closeWebdriver() {
        webDriver.quit();
    }

    @Test
    void testElementsLinks() throws InterruptedException {
        webDriver.get("https://demoqa.com/");
        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//*[text()='Links']")).click();
        webDriver.findElement(By.xpath("//*[@id='simpleLink']")).click();

        String url = webDriver.getCurrentUrl();

        Assert.assertEquals(url, "https://demoqa.com/");
    }
}
