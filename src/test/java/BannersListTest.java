import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BannersListTest {

    @Test
    public void testBannersList() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com/");


        List<String> expectedBannerTitles = new ArrayList<>(Arrays.asList("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"));
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));

        List<String> actualBannerTitles = WebElementToString(elementList);


        Assert.assertEquals(actualBannerTitles, expectedBannerTitles);
        Assert.assertTrue(actualBannerTitles.contains("Book Store Application"));

        driver.quit();
    }

    public static List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }
}
