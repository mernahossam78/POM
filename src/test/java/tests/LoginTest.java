package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest {
    //variables
    WebDriver driver;


    //Tests
    /*
    @Test
    public void validLoginTest() {
        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/inventory.html"));
    }
*/
    //fluent pattern approach
    @Test
    public void validLoginTest() {
        //anonymous object
        new LoginPage(driver).
                login("standard_user", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTest() {
        //anonymous object
        new LoginPage(driver).
                login("merna", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }


    //configurations
    @BeforeMethod
    public void setUp() {
        //Normal method to create driver
        /*
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeoptions);
         */

        //Factory method to create driver
        driver = WebDriverFactory.initDriver("edge");
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        //Normal method to quit driver
        /*
        driver.quit();
         */
        //Factory method to quit driver
        WebDriverFactory.quitDriver();
    }
}
