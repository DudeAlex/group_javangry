package makeev;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class ActionsTest extends BaseTest {

    private Actions actions;

    private Actions getActions() {
        if (actions == null) {
            actions = new Actions(getDriver());
        }
        return actions;
    }

    void goToWebForm() {
        getDriver().findElement(By.linkText("web-form.html")).click();
    }

    void goToDragAndDrop() {
        getDriver().findElement(By.linkText("dragAndDropTest.html")).click();
    }

    @Test
    void testSliderArrowKeys() throws Exception {
        goToWebForm();

        Thread.sleep(2000);
        WebElement range = getDriver().findElement(By.name("my-range"));
        range.sendKeys(Keys.LEFT, Keys.LEFT);
        Thread.sleep(2000);
        range.sendKeys(Keys.LEFT, Keys.LEFT);

        Assert.assertEquals("1", range.getAttribute("value"));
        Thread.sleep(3000);
    }


}
