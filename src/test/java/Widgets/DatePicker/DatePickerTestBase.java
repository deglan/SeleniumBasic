package Widgets.DatePicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePickerTestBase {


    protected WebDriver driver;
    protected DatePickerService datePickerService;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        datePickerService = new DatePickerService(driver);
        driver.get("http://www.seleniumui.moderntester.pl/datepicker.php");
    }
    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

