package other.HighSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HighSiteTestBase {

    WebDriver driver;
    HighSiteTestSuite highSiteTestSuite;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public  void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://www.seleniumui.moderntester.pl/high-site.php");
        highSiteTestSuite = new HighSiteTestSuite();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
