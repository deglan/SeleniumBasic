package Widgets.progressBar;

import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarTest extends ProgressBarTestBase {

    @RepeatedTest(10)
    public void waitForProgressBarCompleteText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d ->
                d.findElement(By.cssSelector("#progressbar .progress-label")).getText().equals("Complete!"));
    }

    @RepeatedTest(10)
    public void waitForProgressBarClass() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d ->
                d.findElement(By.cssSelector("#progressbar .ui-progressbar-value")).getAttribute("class").contains("ui-progressbar-complete"));
    }
}
