import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class JavAngryTest {
    private final static String URL = "https://demoqa.com/";

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
    void testElementsTextBoxValidData() {
        String expectedResult = "Name:Maksim Email:Maksim@test.com Current Address :Saint-Petersburg";
        webDriver.get(URL);
        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text()='Text Box']")).click();
        webDriver.findElement(By.xpath("//input[@id='userName']")).
                sendKeys("Maksim");
        webDriver.findElement(By.xpath("//input[@id='userEmail']")).
                sendKeys("Maksim@test.com");
        webDriver.findElement(By.xpath("//textarea[@id='currentAddress']")).
                sendKeys("Saint-Petersburg");
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
    }

    @Test
    void testRadioButtonYes() {
        webDriver.get(URL);
        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text()='Radio Button']")).click();
        webDriver.findElement(By.xpath("//label[text()='Yes']")).click();
        String text = webDriver.findElement(By.xpath("//span[@class='text-success']")).getText();

        Assert.assertEquals(text, "Yes");
    }


    @Test
    void testAlert() {
        webDriver.get(URL);
        webDriver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
        webDriver.findElement(By.xpath("//span[text()='Alerts']")).click();
        webDriver.findElement(By.xpath("//*[@id='alertButton']")).click();

        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        Assert.assertEquals("You clicked a button", text);
    }
    @Test
    void testDoubleClickButton() {
        String expectedText = "You have done a double click";

        webDriver.get(URL);

        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text() = 'Buttons']")).click();
        WebElement clickable = webDriver.findElement(By.id("doubleClickBtn"));
        new Actions(webDriver)
                .doubleClick(clickable)
                .perform();
        String actualText = webDriver.findElement(By.id("doubleClickMessage")).getText();

        Assert.assertEquals(actualText, expectedText);
    }
}
