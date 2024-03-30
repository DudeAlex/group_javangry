package romirina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolsQaRegTest {
    @Test
    public void webTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        WebElement addBtn = driver.findElement(By.cssSelector("#addNewRecordButton"));
        addBtn.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Irina");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Romanova");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("test@test.ru");

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("18");

        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("180");

        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("IT");

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement currentName = driver.findElement(By.xpath("//div[contains(text(),'Irina')]"));
        String curName = currentName.getText();
        Assert.assertEquals(curName, "Irina");

        driver.quit();

    }
}
