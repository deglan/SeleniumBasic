package basic.form;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class FillForm {

    private final WebDriver driver;

    public void fillForm() {
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("jan.kowalski@example.com");

        List<WebElement> sexCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        sexCheckBoxes.get(getRandomIndex(sexCheckBoxes)).click();

        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("30");

        List<WebElement> experienceCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosExperience']"));
        experienceCheckBoxes.get(getRandomIndex(experienceCheckBoxes)).click();

        List<WebElement> professionCheckBoxes = driver.findElements(By.cssSelector("[name='gridCheckboxProfession']"));
        professionCheckBoxes.get(getRandomIndex(professionCheckBoxes)).click();

        Select countries = new Select(driver.findElement(By.id("selectContinents")));
        countries.selectByIndex(getRandomIndex(countries.getOptions()));

        Select commands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        commands.selectByIndex(getRandomIndex(commands.getOptions()));

        selectFile();

        driver.findElement(By.xpath("//button")).click();
    }

    private void selectFile() {
        File file = new File("src/test/resources/test.txt");
        driver.findElement(By.id(("chooseFile"))).sendKeys(file.getAbsolutePath());
    }

    private static int getRandomIndex(List<WebElement> elements) {
        return new Random().nextInt(elements.size());
    }
}
