package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    //Locators
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.xpath("//span[@class = 'shopping_cart_badge']");
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;


    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    //actions
    /*
    public HomePage addToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }
     */

    //Bot pattern approach
    public HomePage addToCart() {
        actionsBot.click(addToCartButton);
        return this;
    }

    public HomePage validateCartIcon() {
        String cartCount = actionsBot.getText(cartIcon);
        Assert.assertEquals(cartCount, "1");
        return this;
    }

    /*
    public HomePage validateCartIcon() {
        String cartCount = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartCount, "1");
        return this;
    }
     */
}
