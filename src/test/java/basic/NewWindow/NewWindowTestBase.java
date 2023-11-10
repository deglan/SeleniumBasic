package basic.NewWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewWindowTestBase {


    WebDriver driver;
    String mainWindowHandle;
    NewWindowService newWindowService;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public  void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://www.seleniumui.moderntester.pl/windows-tabs.php");
        mainWindowHandle = driver.getWindowHandle();
        newWindowService = new NewWindowService(driver, mainWindowHandle);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
