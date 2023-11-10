package other.DemoQa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoQATest extends DemoQATestBase{



    @RepeatedTest(10)
    public void testSubjectSelection() {
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));

        wait.until(ExpectedConditions.elementToBeClickable(subjectInput));

        subjectInput.sendKeys("m");
        WebElement mathsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", mathsOption);
        mathsOption.click();

        subjectInput.sendKeys("a");
        WebElement artsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-2")));

        js.executeScript("arguments[0].scrollIntoView(true);", artsOption);
        artsOption.click();

        WebElement selectedSubjectsContainer = driver.findElement(By.className("subjects-auto-complete__value-container"));
        String selectedSubjectsText = selectedSubjectsContainer.getText();

        assertThat(selectedSubjectsText).contains("Maths", "Arts");
    }
}
