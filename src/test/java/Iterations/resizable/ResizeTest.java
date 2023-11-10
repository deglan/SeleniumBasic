package Iterations.resizable;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizeTest extends ResizeTestBase {

    @Test
    public void testResize() {

        WebElement resizable = driver.findElement(By.id("resizable"));

        WebElement rightHandle = resizable.findElement(By.cssSelector(".ui-resizable-e"));

        WebElement bottomHandle = resizable.findElement(By.cssSelector(".ui-resizable-s"));

        WebElement bottomRightHandle = resizable.findElement(By.cssSelector(".ui-resizable-se"));

        resizeElement(rightHandle, 10, 0);

        resizeElement(bottomHandle, 0, 10);

        resizeElement(bottomRightHandle, 10, 10);
    }

    private void resizeElement(WebElement resizeHandle, int offsetX, int offsetY) {
        new Actions(driver).clickAndHold(resizeHandle)
                .moveByOffset(offsetX, offsetY)
                .release()
                .perform();
    }
}