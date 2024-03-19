import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

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
    void testElementsLinks() {
        webDriver.get("https://demoqa.com/");
        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//*[text()='Links']")).click();
        webDriver.findElement(By.xpath("//*[@id='simpleLink']")).click();

        String currentWindow = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindow)) {        // Переключаемся на новую вкладку
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        String url = webDriver.getCurrentUrl();

        Assert.assertEquals(url, "https://demoqa.com/");
    }
}
