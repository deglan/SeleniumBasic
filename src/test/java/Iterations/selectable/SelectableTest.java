package Iterations.selectable;

import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectableTest extends  SelectableTestBase {

    @RepeatedTest(10)
    public void testSelectableItems() {


        WebElement selectableList = driver.findElement(By.id("selectable"));

        WebElement item1 = selectableList.findElements(By.tagName("li")).get(0);
        WebElement item3 = selectableList.findElements(By.tagName("li")).get(2);
        WebElement item4 = selectableList.findElements(By.tagName("li")).get(3);

        Actions actions = new Actions(driver);
        actions.click(item1)
                .perform();

        WebElement resultElement = driver.findElement(By.id("feedback"));
        String resultText = resultElement.getText();

        assertThat(resultText).as("Check selected items text").isEqualTo("You've selected: #1.");
        actions.click(item3)
                .perform();

        resultElement = driver.findElement(By.id("feedback"));
        resultText = resultElement.getText();

        assertThat(resultText).as("Check selected items text").isEqualTo("You've selected: #3.");
        actions.click(item4)
                .perform();

        resultElement = driver.findElement(By.id("feedback"));
        resultText = resultElement.getText();

        assertThat(resultText).as("Check selected items text").isEqualTo("You've selected: #4.");
    }
}
