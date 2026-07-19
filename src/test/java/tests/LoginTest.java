package tests;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.PropertyReader.getProperty;


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
    @Description("Verify that the user is redirected to home page after providing the right credentials")
    @Tag("validation")
    @Owner("Merna")
    @Severity(SeverityLevel.CRITICAL)
    public void validLoginTest() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Valid Login");
        });
        //anonymous object
        new LoginPage(driver).
                login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTest() {
        //anonymous object
        new LoginPage(driver).
                login(getProperty("invalidUsername"), getProperty("invalidPassword"))
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
        driver = WebDriverFactory.initDriver();
        driver.get(getProperty("baseUrl"));

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
