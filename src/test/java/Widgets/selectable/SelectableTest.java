package Widgets.selectable;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectableTest extends SelectableTestBase{

    @Test
    public void testSelectable() {
        // Select a random speed
        driver.findElement(By.id("speed-button")).click();
        List<WebElement> speedOptions = driver.findElements(By.cssSelector("#speed-menu li"));
        speedOptions.get(random.nextInt(speedOptions.size())).click();

        // Select a file by text
        driver.findElement(By.id("files-button")).click();
        driver.findElement(By.xpath("//ul[@id='files-menu']//div[text()='jQuery.js']"))
                .click();

        // Select a number by index
        driver.findElement(By.id("number-button")).click();
        List<WebElement> numberOptions = driver.findElements(By.cssSelector("#number-menu li"));
        numberOptions.get(2).click(); // Index 2 for third option

        // Select a random title
        driver.findElement(By.id("salutation-button")).click();
        List<WebElement> titleOptions = driver.findElements(By.cssSelector("#salutation-menu li"));
        titleOptions.get(random.nextInt(titleOptions.size())).click();
    }
}
