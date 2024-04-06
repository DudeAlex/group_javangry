package mariJern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AskomdchMJTest extends BaseTest {

    private static final String URL_HOME = "https://askomdch.com/";
    private static final String URL_SHOP = "https://askomdch.com/store";
    private static final String URL_CART = "https://askomdch.com/cart/";
    private static final String URL_CheckOut = "https://askomdch.com/checkout/";
    private static final String URL_BOHO = "https://askomdch.com/product/boho-bangle-bracelet/";

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
        getDriver().get(URL_BOHO);
        getDriver().findElement(By.xpath("//button[@name='add-to-cart']")).click();
        getDriver().findElement(By.className("wc-forward")).click();
        getDriver().findElement(By.xpath("//div[@class='wc-proceed-to-checkout']")).click();

        WebElement billingState = getDriver().findElement(By.xpath("//*[@id='billing_state']"));

        String actualStates = billingState.getText();
        String expectedStates = "Select an option…\n" +
                "Alabama\n" +
                "Alaska\n" +
                "Arizona\n" +
                "Arkansas\n" +
                "California\n" +
                "Colorado\n" +
                "Connecticut\n" +
                "Delaware\n" +
                "District Of Columbia\n" +
                "Florida\n" +
                "Georgia\n" +
                "Hawaii\n" +
                "Idaho\n" +
                "Illinois\n" +
                "Indiana\n" +
                "Iowa\n" +
                "Kansas\n" +
                "Kentucky\n" +
                "Louisiana\n" +
                "Maine\n" +
                "Maryland\n" +
                "Massachusetts\n" +
                "Michigan\n" +
                "Minnesota\n" +
                "Mississippi\n" +
                "Missouri\n" +
                "Montana\n" +
                "Nebraska\n" +
                "Nevada\n" +
                "New Hampshire\n" +
                "New Jersey\n" +
                "New Mexico\n" +
                "New York\n" +
                "North Carolina\n" +
                "North Dakota\n" +
                "Ohio\n" +
                "Oklahoma\n" +
                "Oregon\n" +
                "Pennsylvania\n" +
                "Rhode Island\n" +
                "South Carolina\n" +
                "South Dakota\n" +
                "Tennessee\n" +
                "Texas\n" +
                "Utah\n" +
                "Vermont\n" +
                "Virginia\n" +
                "Washington\n" +
                "West Virginia\n" +
                "Wisconsin\n" +
                "Wyoming\n" +
                "Armed Forces (AA)\n" +
                "Armed Forces (AE)\n" +
                "Armed Forces (AP)";

        Assert.assertEquals(actualStates, expectedStates);
    }
}





