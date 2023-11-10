package basic.NewWindow;

import basic.Table.TableCheck;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

@AllArgsConstructor
public class NewWindowService {

    WebDriver driver;
    String mainWindowHandle;

    public void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(mainWindowHandle);

        if (!windowHandles.isEmpty()) {
            driver.switchTo().window(windowHandles.iterator().next());
        }
    }

    public void switchToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    public void switchToNewTab() {
        for (String tabHandle : driver.getWindowHandles()) {
            if (!tabHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(tabHandle);
                break;
            }
        }
    }

    public void executeStepsFromTablesExercise() {
        TableCheck tableCheck = new TableCheck();
        tableCheck.checkTableWithSwitzerlandAndHeight(driver);
    }

    public void closeAndSwitchBackToMain() {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }
}
