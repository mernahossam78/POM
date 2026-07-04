package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //locators
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;


    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;  //el driver ely f el test hwa ely hyshtghl f b3ml kda 34an lma a3mlo initialize, el data ely feh tegy hna w a3f ashghl el driver ely hna
        this.actionsBot = new ActionsBot(driver);
    }


    //actions
    //Bot pattern approach
    public LoginPage login(String user, String pass) {
        actionsBot.type(userName, user);
        actionsBot.type(password, pass);
        actionsBot.click(loginButton);
        return this;
    }
    /*
    public void login(String user, String pass) {
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();

    }
*/
    //fluent pattern approach
    /*
    public LoginPage login(String user, String pass) {
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        return this;
    }

     */

    /*
        //this function is just to get the current url with true or false for assertion
        public boolean isLoggedIn(String expectedUrl) {
            return driver.getCurrentUrl().equals(expectedUrl);
        }
    */
    //Fluent pattern approach
    public HomePage isLoggedIn(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl().equals(expectedUrl), true);
        return new HomePage(driver);
    }
}
