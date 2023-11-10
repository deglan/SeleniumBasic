package Widgets.Slider;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveSlider {

    public void moveSlider(WebDriver driver,int targetValue) {
        WebElement sliderHandle = driver.findElement(By.id("custom-handle"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.left = '" + targetValue + "%';", sliderHandle);

        String newValue = sliderHandle.getAttribute("style");
        int newSliderValue = Integer.parseInt(newValue.replaceAll("[^0-9]", ""));

        assertThat(newSliderValue).as("Check if slider moved to correct position").isEqualTo(targetValue);
    }

}
