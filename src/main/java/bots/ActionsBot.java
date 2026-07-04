package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBot {
    //that class will contain all the actions that we will reuse
    //type, click and get text
    private WebDriver driver;
    private WaitBot waitBot;

    //constructor
    public ActionsBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    //Clicking
    public void click(By locator) {
        waitBot.fluentWait().until(d ->
                {
                    try {

                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.click();
                        return true;

                    } catch (Exception e) {
                        return false; //false here means that the until wil restart all over again
                        //the only way for until to finish is to return true or throw an exception, if we return false it will keep trying until the timeout is reached
                    }
                }
        );


    }


    //Typing
    public void type(By locator, String text) {
        waitBot.fluentWait().until(d ->
                {
                    try {

                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.clear();
                        element.sendKeys(text);
                        return true;

                    } catch (Exception e) {
                        return false; //false here means that the until wil restart all over again
                        //the only way for until to finish is to return true or throw an exception, if we return false it will keep trying until the timeout is reached
                    }
                }
        );

    }


    //Getting text
    public String getText(By locator) {

        return waitBot.fluentWait().until(d ->
                {
                    try {

                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        String msg = element.getText();
                        return !msg.isEmpty() ? msg : null;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }

}
