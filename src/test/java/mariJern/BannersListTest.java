package mariJern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannersListTest {

    private WebDriver webDriver;
    @BeforeTest
    public void initWebDriverOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    webDriver = new ChromeDriver((chromeOptions));
    chromeOptions.addArguments("--window-size=1920,1080");
    }

    @AfterTest
    public void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    public void testBannersList() {

        webDriver.get("https://demoqa.com/");

        List<String> expectedBannerTitles = new ArrayList<>(Arrays.asList("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"));
        List<WebElement> elementList = webDriver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
        List<String> actualBannerTitles = WebElementToString(elementList);


        Assert.assertEquals(actualBannerTitles, expectedBannerTitles);
        Assert.assertTrue(actualBannerTitles.contains("Book Store Application"));
    }

    public static List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }
}
