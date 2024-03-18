import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JavAngryTest {

    @Test
    void elementsTextBoxValidDataTest() {
        String expectedResult = "Name:Maksim Email:Maksim@test.com Current Address :Saint-Petersburg";
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/");
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
        webDriver.quit();
    }
}
