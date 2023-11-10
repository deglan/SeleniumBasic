package Iterations.dragable;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragTest extends DragTestBase {
    @RepeatedTest(10)
    public void testDragSquare() {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", draggable);

        dragMove.dragElementToTarget(actions, draggable, "upperRight");

        dragMove.dragElementToTarget(actions, draggable, "bottomRight");

        dragMove.dragElementToTarget(actions, draggable, "center");

        dragMove.dragElementToTarget(actions, draggable, "bottomLeft");
    }


}
