package basic.Iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FillIframes {

    public void fillUpFirstIframe(WebDriver driver) {
        driver.switchTo().frame("iframe1");

        driver.findElement(By.id("inputFirstName3")).sendKeys("John");
        driver.findElement(By.id("inputSurname3")).sendKeys("Doe");
        driver.findElement(By.cssSelector("button")).click();

        driver.switchTo().defaultContent();
    }

    public void fillUpSecondIframe(WebDriver driver){
        driver.switchTo().frame("iframe2");

        driver.findElement(By.id("inputLogin")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("inputPassword")).sendKeys("secret123");

        Select countries = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        countries.selectByIndex(getRandomIndex(countries.getOptions()));

        List<WebElement> experienceCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadios']"));
        experienceCheckBoxes.get(getRandomIndex(experienceCheckBoxes)).click();

        driver.findElement(By.cssSelector("button")).click();
        driver.switchTo().defaultContent();
    }

    private int getRandomIndex(List<WebElement> elements) {
        return new Random().nextInt(elements.size());
    }
}
