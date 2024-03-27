import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class JavAngryTest {
    private WebDriver webDriver;

    @BeforeMethod
    private void createWebDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    private void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    void testElementsTextBoxValidData() {
        String expectedResult = "Name:Maksim Email:Maksim@test.com Current Address :Saint-Petersburg";
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
    }

    @Test
    void testRadioButtonYes() {
        webDriver.get("https://demoqa.com/");
        webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
        webDriver.findElement(By.xpath("//span[text()='Radio Button']")).click();
        webDriver.findElement(By.xpath("//label[text()='Yes']")).click();
        String text = webDriver.findElement(By.xpath("//span[@class='text-success']")).getText();

        Assert.assertEquals(text, "Yes");
    }


    @Test
    void testAlert() {
        webDriver.get("https://demoqa.com/");
        webDriver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
        webDriver.findElement(By.xpath("//span[text()='Alerts']")).click();
        webDriver.findElement(By.xpath("//*[@id='alertButton']")).click();

        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        Assert.assertEquals("You clicked a button", text);

    }

    @Test
    public void addingInfoToWebTablesTest() {

        String expectedResult = "John\n" +
                "Dou\n" +
                "27\n" +
                "jm@example.com\n" +
                "1500\n" +
                "Marketing";

        //webDriver.get(URL);
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

        Assert.assertEquals(resultActual.toString(), expectedResult);
    }
}
