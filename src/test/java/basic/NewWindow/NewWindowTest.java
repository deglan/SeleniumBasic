package basic.NewWindow;

import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;

public class NewWindowTest extends NewWindowTestBase {

    @RepeatedTest(10)
    public void testOpenNewBrowserWindowAndTab() {
        driver.findElement(By.id("newBrowserWindow")).click();
        newWindowService.switchToNewWindow();
        newWindowService.executeStepsFromTablesExercise();
        newWindowService.closeAndSwitchBackToMain();
        newWindowService.switchToMainWindow();
        driver.findElement(By.id("newMessageWindow")).click();
        newWindowService.switchToNewWindow();
        String newWindowText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text in the new window: " + newWindowText);
        newWindowService.closeAndSwitchBackToMain();
        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        newWindowService.switchToNewTab();
        newWindowService.executeStepsFromTablesExercise();
        newWindowService.closeAndSwitchBackToMain();
    }


}
