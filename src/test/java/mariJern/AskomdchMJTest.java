package mariJern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AskomdchMJTest extends BaseTest {

    private static final String URL_HOME = "https://askomdch.com/";
    private static final String URL_SHOP = "https://askomdch.com/store";
    private static final String URL_CART = "https://askomdch.com/cart/";
    private static final String URL_CheckOut = "https://askomdch.com/checkout/";
    private static final String URL_BOHO = "https://askomdch.com/product/boho-bangle-bracelet/";


    private void addBohoToCartAndGotoCheckout() {
        getDriver().get(URL_BOHO);
        getDriver().findElement(By.xpath("//button[@name='add-to-cart']")).click();
        getDriver().findElement(By.className("wc-forward")).click();
        getDriver().findElement(By.xpath("//div[@class='wc-proceed-to-checkout']")).click();
    }

    @Test
    public void testEmptyCartNoticeText() {
        getDriver().get(URL_CART);

        String actualNotice = getDriver().findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"))
                .getText();
        String expectedNotice = "Your cart is currently empty.";

        Assert.assertEquals(actualNotice, expectedNotice);
    }

    @Test
    public void testShopNowButtonText() {
        getDriver().get(URL_HOME);
        String expectedButtonName = getDriver().findElement(By.xpath("//a[@href='/store']"))
                .getText();

        Assert.assertTrue(expectedButtonName.contains("SHOP NOW"));
    }

    @Test
    public void testShopNowButtonLink() {
        getDriver().get(URL_HOME);
        getDriver().findElement(By.xpath("//a[@href='/store']"))
                .click();
        String CurrentUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(CurrentUrl, URL_SHOP);
    }

    @Test
    public void testSearchFieldInput() {
        getDriver().get(URL_HOME);

        WebElement shopNowButton = getDriver().findElement(By.className("wp-block-button"));
        shopNowButton.click();
        WebElement searchField = getDriver().findElement(By.className("search-field"));
        searchField.sendKeys(("boho"));
        WebElement searchButton = getDriver().findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();
        String bohoBracelet = getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertEquals("Boho Bangle Bracelet", bohoBracelet);
        Assert.assertEquals(getDriver().getCurrentUrl(), URL_BOHO);
    }

    @Test
    public void testAddBohoToCartAndCheckout() {
        getDriver().get(URL_BOHO);

        WebElement addToCartButton = getDriver().findElement(By.xpath("//button[@name='add-to-cart']"));
        addToCartButton.click();
        String ExpectedText = "“Boho Bangle Bracelet” has been added to your cart.";
        String ActualText = getDriver().findElement(By.xpath("//*[text()=' " + ExpectedText + " ']")).getText();

        Assert.assertTrue(ActualText.contains(ExpectedText));


        WebElement viewCartButton = getDriver().findElement(By.className("wc-forward"));
        viewCartButton.click();
        WebElement productName = getDriver().findElement(By.xpath("//*[@data-title='Product']"));

        Assert.assertEquals(productName.getText(), "Boho Bangle Bracelet");

        WebElement checkoutButton = getDriver().findElement(By.xpath("//div[@class='wc-proceed-to-checkout']"));
        checkoutButton.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), URL_CheckOut);
    }

    @Test
    public void testStatesList() {
        addBohoToCartAndGotoCheckout();

        WebElement billingState = getDriver().findElement(By.xpath("//*[@id='billing_state']"));

        String actualStates = billingState.getText();
        String expectedStates = """
                Select an option…
                Alabama
                Alaska
                Arizona
                Arkansas
                California
                Colorado
                Connecticut
                Delaware
                District Of Columbia
                Florida
                Georgia
                Hawaii
                Idaho
                Illinois
                Indiana
                Iowa
                Kansas
                Kentucky
                Louisiana
                Maine
                Maryland
                Massachusetts
                Michigan
                Minnesota
                Mississippi
                Missouri
                Montana
                Nebraska
                Nevada
                New Hampshire
                New Jersey
                New Mexico
                New York
                North Carolina
                North Dakota
                Ohio
                Oklahoma
                Oregon
                Pennsylvania
                Rhode Island
                South Carolina
                South Dakota
                Tennessee
                Texas
                Utah
                Vermont
                Virginia
                Washington
                West Virginia
                Wisconsin
                Wyoming
                Armed Forces (AA)
                Armed Forces (AE)
                Armed Forces (AP)""";

        Assert.assertEquals(actualStates, expectedStates);
    }

    @Test
    public void testSelectStateAndCheckout() throws InterruptedException {

        String expectedText = "Thank you. Your order has been received.";

        addBohoToCartAndGotoCheckout();
        getDriver().findElement(By.id("billing_first_name")).sendKeys("Joe");
        getDriver().findElement(By.id("billing_last_name")).sendKeys("Doe");

        final WebElement selectCountry = getDriver().findElement(By.id("billing_country"));
        Select fromDropdown = new Select(selectCountry);
        fromDropdown.selectByValue("LV");

        getDriver().findElement(By.id("billing_address_1")).sendKeys("123 Test Street");
        getDriver().findElement(By.id("billing_city")).sendKeys("Riga");
        getDriver().findElement(By.id("billing_postcode")).sendKeys("LV-1010");
        getDriver().findElement(By.id("billing_email")).sendKeys("test@test.com");
        Thread.sleep(1000);
        getDriver().findElement(By.id("place_order")).click();
        Thread.sleep(2000);

        Assert.assertEquals(getDriver().findElement(By.xpath("/html/body/div/div[1]/div/div/main/article/div/div/div/div/div/p")).getText(), expectedText);
    }
}





