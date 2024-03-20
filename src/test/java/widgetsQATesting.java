import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class widgetsQATesting {
    private WebDriver webDriver;

    @BeforeTest
    private void createWebDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterTest
    private void closeWebDriver() {
        webDriver.quit();
    }

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
}
