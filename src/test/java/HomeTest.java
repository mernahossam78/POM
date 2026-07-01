import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    //variables
    WebDriver driver;

    @Test
    public void addToCartTC() {
        new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addToCart()
                .validateCartIcon();
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
