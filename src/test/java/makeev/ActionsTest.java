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

    @Test
    void testKeyAction() throws Exception {
        goToWebForm();

        WebElement textAres = getDriver().findElement(By.name("my-textarea"));
        Thread.sleep(2000);
        getActions().click(textAres)
                .keyDown(Keys.SHIFT)
                .sendKeys("abCDe")
                .keyUp(Keys.SHIFT)
                .perform();

        Assert.assertEquals("ABCDE", textAres.getAttribute("value"));

        Thread.sleep(2000);
    }

    @Test
    void testDragAndDrop() throws Exception {
        goToDragAndDrop();

        WebElement test1 = getDriver().findElement(By.id("test1"));
        Thread.sleep(2000);
        getActions()
                .clickAndHold(test1)
                .moveByOffset(100, 50)
                .pause(1000)
                .moveByOffset(200, 100)
                .release()
                .perform();

        System.out.println(test1.getLocation());
        Thread.sleep(2000);
    }

    @Test
    void testDragAndDropBy() throws Exception {
        goToDragAndDrop();

        WebElement test2 = getDriver().findElement(By.id("test2"));
        getActions()
                .dragAndDropBy(test2, 200, 300)
                .perform();

        System.out.println(test2.getLocation());
        Thread.sleep(2000);
    }

    @Test
    void testDragAndDropToElement() throws Exception {
        goToDragAndDrop();

        WebElement test1 = getDriver().findElement(By.id("test1"));
        System.out.println("test1.getLocation: " + test1.getLocation());

        WebElement test4 = getDriver().findElement(By.id("test4"));

        getActions()
                .dragAndDrop(test1, test4)
                .perform();

        System.out.println("test1.getLocation: " + test1.getLocation());

        Assert.assertEquals(test4.getLocation(), test1.getLocation());

        Thread.sleep(2000);
    }

    @Test
    void testColor() throws Exception {
        goToWebForm();

        final WebElement colorPicker = getDriver().findElement(By.name("my-colors"));
        System.out.println("color of Picker in the Start: " + colorPicker.getAttribute("value"));
        Thread.sleep(2000);
        colorPicker.click();
        getActions()
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB)
                .sendKeys("255")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("0")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("0")
                .pause(1000)
                .sendKeys(Keys.ENTER)
                .pause(1000)
                .perform();

        final String color = colorPicker.getAttribute("value");
        System.out.println("color of Picker in the End : " + color);

        Assert.assertEquals("#ff0000" , color);

        Thread.sleep(2000);
    }


}
