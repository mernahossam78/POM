import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    //variables
    WebDriver driver;


    //Tests
    /*
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
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
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeoptions);
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
