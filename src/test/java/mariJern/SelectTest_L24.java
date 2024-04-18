package mariJern;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class SelectTest_L24 extends BaseTest {

/*    void goToSelectPage() {
        getDriver().findElement(By.linkText("selectPage.html")).click();
    }*/

    @Test
    public void testSimpleDropdown() throws InterruptedException {
        //goToSelectPage();
        getDriver().get("https://selenium.dev/selenium/web/selectPage.html");
        final WebElement selectWithoutMultiple = getDriver().findElement(By.id("selectWithoutMultiple"));
        Select simpleDropdown = new Select(selectWithoutMultiple);
        simpleDropdown.selectByValue("two");

        String newValue = selectWithoutMultiple.getAttribute("value");
        System.out.println(newValue);
        Assert.assertEquals("two", newValue);

        Thread.sleep(3000);
    }

    @Test
    public void testMultipleSelect() throws InterruptedException {

        getDriver().get("https://selenium.dev/selenium/web/selectPage.html");
        final WebElement selectElement = getDriver().findElement(By.id("selectWithMultipleEqualsMultiple"));
        Select multiSelect = new Select(selectElement);
        multiSelect.selectByIndex(1);
        Thread.sleep(1000);
        //multiSelect.deselectByIndex(0);
        multiSelect.selectByIndex(3);
        multiSelect.selectByVisibleText("Parmigiano");

        System.out.println(selectElement.getAttribute("value"));
        System.out.println(multiSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList()));

        Thread.sleep(3000);
    }

    @Test
    void testLongList() {
        getDriver().get("https://selenium.dev/selenium/web/selectPage.html");
        WebElement selectElement = getDriver().findElement(By.id("selectWithMultipleLongList"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("five");
        select.selectByVisibleText("six");

        System.out.println(selectElement.getAttribute("value"));
        System.out.println(select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList()));
    }
}
