package basic.form;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

@AllArgsConstructor
public class FileDownloadHelper {

    private final WebDriver driver;

    public void clickDownloadButton() {
        driver.findElement(By.linkText("Test File to Download")).click();
    }

    public int getFileCountInDirectory(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        return files != null ? files.length : 0;
    }

    public boolean doesFileExistInDirectory(String directoryPath, String fileName) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void waitForDownloadCompletion(String directoryPath, int initialFileCount) {
        File folder = new File(directoryPath);
        new WebDriverWait(driver, Duration.ofSeconds(300)).until((WebDriver d) ->
                folder.listFiles().length > initialFileCount
        );
    }
}
