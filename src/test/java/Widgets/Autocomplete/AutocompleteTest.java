package Widgets.Autocomplete;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AutocompleteTest extends AutocompleteTestBase {

    @RepeatedTest(10)
    public void testAutocomplete() {

        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("a");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        By autocompleteOptionsSelector = By.cssSelector(".ui-menu-item");
        wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteOptionsSelector));

        List<WebElement> options = driver.findElements(autocompleteOptionsSelector);
        options.forEach(option -> System.out.println(option.getText()));

        Assertions.assertThat(options).isNotEmpty();

        WebElement selectedOption = options.get(new Random().nextInt(options.size()));
        String selectedText = selectedOption.getText();
        selectedOption.click();

        wait.until(ExpectedConditions.attributeToBe(searchInput, "value", selectedText));

        String searchText = searchInput.getAttribute("value");
        Assertions.assertThat(searchText).isEqualTo(selectedText);
    }
}
