package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

public class HomeTest {
    //variables
    WebDriver driver;
    JsonReader jsonReader;

    @Test
    public void addToCartTC() {
        new LoginPage(driver)
                .login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addToCart()
                .validateCartIcon();
    }

    //configurations
    @BeforeMethod
    public void setUp() {
        jsonReader = new JsonReader("login-data");
        //Normal method to create driver
        /*
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeoptions);
        driver.get("https://www.saucedemo.com/");

         */
        //Factory method to create driver
        driver = WebDriverFactory.initDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        //Normal method to quit driver
        /*
        driver.quit();

         */
        WebDriverFactory.quitDriver();
    }
}
