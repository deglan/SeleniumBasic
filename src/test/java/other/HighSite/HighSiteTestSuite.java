package other.HighSite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HighSiteTestSuite {

    public void scrollUntilVisible(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Long lastHeight = (Long) js.executeScript("return window.scrollY");

        while (true) {
            try {

                WebElement element = driver.findElement(locator);
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (NoSuchElementException | TimeoutException e) {

                js.executeScript("window.scrollBy(0,100)");

                Long currentHeight = (Long) js.executeScript("return window.scrollY");
                if (lastHeight.equals(currentHeight)) {
                    throw new NoSuchElementException("Element not found or not scrollable to element with locator: " +
                            locator.toString());
                }
                lastHeight = currentHeight;
            }
        }
    }

    public void scrollUntilVisibleWithActions(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        while (true) {
            try {
                WebElement element = driver.findElement(locator);
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (NoSuchElementException e) {
                actions.scrollByAmount(0, 100).perform();
            }
        }
    }

    public void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + fileName + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved as: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
