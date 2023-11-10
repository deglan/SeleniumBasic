package Widgets.menu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTestBase {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public  void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options); // Initialize driver first
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Then initialize wait
        driver.get("http://www.seleniumui.moderntester.pl/menu-item.php");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
