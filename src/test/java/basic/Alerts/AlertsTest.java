package basic.Alerts;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest extends AlertsTestBase {

    @RepeatedTest(10)
    public void shouldHandleSimpleAlert() {
        WebElement simpleAlertButton = driver.findElement(By.id("simple-alert"));
        simpleAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        WebElement resultMessage = driver.findElement(By.id("simple-alert-label"));
        Assertions.assertThat(resultMessage.getText()).isEqualTo("OK button pressed");
    }

    @RepeatedTest(10)
    public void shouldHandlePromptAlert() {

        WebElement promptAlertButton = driver.findElement(By.id("prompt-alert"));
        promptAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Lord Vader");
        promptAlert.accept();

        WebElement resultMessage = driver.findElement(By.id("prompt-label"));
        Assertions.assertThat(resultMessage.getText()).isEqualTo("Hello Lord Vader! How are you today?");
    }

    @RepeatedTest(10)
    public void shouldHandleConfirmAlert() {

        WebElement confirmAlertButton = driver.findElement(By.id("confirm-alert"));
        confirmAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        WebElement resultMessage = driver.findElement(By.id("confirm-label"));
        Assertions.assertThat(resultMessage.getText()).isEqualTo("You pressed OK!");

        confirmAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();

        resultMessage = driver.findElement(By.id("confirm-label"));
        Assertions.assertThat(resultMessage.getText()).isEqualTo("You pressed Cancel!");
    }

    @RepeatedTest(10)
    public void shouldHandleDelayedAlert() {

        WebElement delayedAlertButton = driver.findElement(By.id("delayed-alert"));
        delayedAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100000L));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert delayedAlert = driver.switchTo().alert();
        delayedAlert.accept();

        WebElement resultMessage = driver.findElement(By.id("delayed-alert-label"));
        Assertions.assertThat(resultMessage.getText()).isEqualTo("OK button pressed");
    }
}
