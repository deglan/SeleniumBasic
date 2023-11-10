package Iterations.dropable;

import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DropTest extends DropTestBase {

    @RepeatedTest(10)
    public void testDragAndDrop() {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable)
                .moveToElement(dropTarget)
                .release()
                .perform();

        WebElement resultElement = driver.findElement(By.id("droppable"));
        String resultText = resultElement.getText();

        assertThat(resultText).as("Check if text 'Dropped!' appeared").contains("Dropped!");
    }
}
