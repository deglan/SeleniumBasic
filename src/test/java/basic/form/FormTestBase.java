package basic.form;

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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormTestBase {
    WebDriver driver;
    static String downloadPath = System.getProperty("user.dir") + "/downloadTest";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        new File(downloadPath).mkdirs();
    }

    @BeforeEach
    public void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
    }


    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
