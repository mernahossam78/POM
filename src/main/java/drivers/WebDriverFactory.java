package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static WebDriver getDriver(String browser) {
        /*
        return switch (browser) {
            case "chrome" -> new ChromeFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException("Browser not supported " + browser);
        };
        the above code is a switch statement that returns an AbstractDriver object based on the browser parameter. If the browser parameter is "chrome", it returns a new ChromeFactory object. If the browser parameter is "edge", it returns a new EdgeFactory object. If the browser parameter is anything else, it throws an IllegalArgumentException with a message indicating that the browser is not supported.
        it is not recommended so we will implement it with another method that applies the O in SOLID principles
         */
        Browser browserEnum = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserEnum.getDriverFactory();
        return abstractDriver.createDriver();
    }

    public static WebDriver initDriver(String browser) {
        WebDriver driver = ThreadGuard.protect(getDriver(browser));
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }
}
