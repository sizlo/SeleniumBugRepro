import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeleniumTest {
    @Test
    public void mobileTest() {
        findDriverBinaryAt("chromedriver");
        WebDriver driver = createMobileEmulationDriver();
        driver.get("https://sell.carzone.ie/sell-your-car#/edit");
        waitForSeconds(3);
        driver.findElement(By.className("btn-open-register")).click();
        waitForSeconds(3);
        driver.findElement(By.id("terms"));
    }

    @Test
    public void desktopTest() {
        findDriverBinaryAt("chromedriver");
        WebDriver driver = createDesktopDriver();
        driver.get("https://sell.carzone.ie/sell-your-car#/edit");
        waitForSeconds(3);
        driver.findElement(By.className("btn-open-register")).click();
        waitForSeconds(3);
        driver.findElement(By.id("terms"));
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

    private void waitForSeconds(final int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}
