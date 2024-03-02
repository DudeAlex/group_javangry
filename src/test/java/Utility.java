import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
    public static void greeting() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://telegra.ph/Privet-druzya-03-02-2");
        Thread.sleep(10000);
        driver.quit();
    }
}
