import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

class Driver {
    static final String URL = "https://192.168.100.26/";
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static ThreadLocal<WebDriver> getDriver() {
        if (driver.get() == null) {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("acceptInsecureCerts", true);
            WebDriver d = new ChromeDriver(caps);
            d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            d.manage().window().maximize();
            driver.set(d);
        }
        return driver;
    }

    static void openLoginPage() {
            getDriver().get().navigate().to(URL);
    }

    static void closeDriver() {
        driver.get().close();
        driver.set(null);
    }
}
