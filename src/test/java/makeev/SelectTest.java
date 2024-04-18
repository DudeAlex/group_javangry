package makeev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class SelectTest extends BaseTest {

    void goToSelectPage() {
        getDriver().findElement(By.linkText("selectPage.html")).click();
    }

    @Test
    public void testSimpleDropDown() throws Exception {
        goToSelectPage();

        final WebElement selectWithoutMultiple = getDriver().findElement(By.id("selectWithoutMultiple"));

        Select simpleDropDown = new Select(selectWithoutMultiple);

        Thread.sleep(5000);
        simpleDropDown.selectByValue("two");

        String newValue = selectWithoutMultiple.getAttribute("value");
        System.out.println(newValue);

        Assert.assertEquals("two", newValue);

        Thread.sleep(3000);
    }







}
