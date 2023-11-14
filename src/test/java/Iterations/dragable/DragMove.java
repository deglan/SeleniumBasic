package Iterations.dragable;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@AllArgsConstructor
public class DragMove {
    private WebDriver driver;
    public void dragElementToTarget(Actions actions, WebElement element, String target) {
        Point elementLocation = element.getLocation();
        Dimension windowSize = driver.manage().window().getSize();
        Dimension elementSize = element.getSize();

        int offsetX = 0;
        int offsetY = 0;

        switch (target) {
            case "upperRight":
                offsetX = windowSize.getWidth() - elementLocation.getX() - elementSize.getWidth() - elementSize.getHeight();
                offsetY = -elementLocation.getY();
                break;
            case "bottomRight":
                offsetX = windowSize.getWidth() - elementLocation.getX() - elementSize.getWidth() - elementSize.getHeight();
                offsetY = windowSize.getHeight() - elementLocation.getY() - elementSize.getHeight() - elementSize.getWidth();
                break;
            case "center":
                offsetX = (windowSize.getWidth() / 2) - (elementLocation.getX() + elementSize.getWidth() / 2 + elementSize.getHeight() / 2);
                offsetY = (windowSize.getHeight() / 2) - (elementLocation.getY() + elementSize.getHeight() / 2 + elementSize.getWidth() / 2);
                break;
            case "bottomLeft":
                offsetX = -elementLocation.getX();
                offsetY = windowSize.getHeight() - elementLocation.getY() - elementSize.getHeight() - elementSize.getWidth();
                break;
            default:
                System.out.println("Wrong value");
                break;
        }

        System.out.println("Dragging to " + target + " with offsets: " + offsetX + ", " + offsetY);
        actions.dragAndDropBy(element, offsetX, offsetY).perform();
    }
}
