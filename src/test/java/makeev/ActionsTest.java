package makeev;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

    @Test
    void testSliderAction() throws Exception {
        goToWebForm();

        WebElement range = getDriver().findElement(By.xpath("//input[@name='my-range']"));
        Thread.sleep(2000);
        getActions()    // Actions
                .clickAndHold(range)    // Actions
                .moveByOffset(-100, 0)  // Actions
                .release()  // Actions
                .perform(); // void

        System.out.println(range.getAttribute("value"));
        Assert.assertEquals("3", range.getAttribute("value"));

        Thread.sleep(2000);
    }
    
    @Test
    void testRangeClick() throws Exception {
        goToWebForm();
        
        WebElement range = getDriver().findElement(By.name("my-range"));

        final Dimension size = range.getSize();
        int rangeWidth = size.getWidth();
        Thread.sleep(2000);
        getActions().moveToElement(range)
                .moveByOffset(rangeWidth * 2 / 5, 0)
                .click()
                .perform();
        System.out.println(range.getAttribute("value"));
        Thread.sleep(2000);
        
        
    }

}
