package Iterations.sortable;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableTest  extends SortableTestBase {

    @Test
    public void testShuffleAndSort() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<WebElement> items = driver.findElements(By.cssSelector("#sortable > li"));

        for (int number : numbers) {
            WebElement itemToMove = items.get(number - 1);

            WebElement targetLocation = items.get(numbers.indexOf(number));

            new Actions(driver).clickAndHold(itemToMove)
                    .moveToElement(targetLocation)
                    .release()
                    .perform();
        }
    }
}
