import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SeleniumTest {
    @Test
    public void mobileTest() {
        findDriverBinaryAt("chromedriver");
        WebDriver driver = createMobileEmulationDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void desktopTest() {
        findDriverBinaryAt("chromedriver");
        WebDriver driver = createDesktopDriver();
        driver.get("https://google.com/");
    }

    private void findDriverBinaryAt(String driverLocation) {
        System.setProperty("webdriver.chrome.driver", driverLocation);
    }

    private WebDriver createMobileEmulationDriver() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver createDesktopDriver() {
        return new ChromeDriver(new ChromeOptions());
    }
}
