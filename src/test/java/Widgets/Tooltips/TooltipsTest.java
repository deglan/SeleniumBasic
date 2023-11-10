package Widgets.Tooltips;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TooltipsTest extends TooltipsTestBase {

    @Test
    public void testSliderMoves() {
        WebElement elementWithTooltip = driver.findElement(By.xpath("//a[@title]"));
        String tooltipText = elementWithTooltip.getAttribute("title");
        System.out.println("Tooltip text: " + tooltipText);
        assertThat(tooltipText).as("Check tooltip text").isEqualTo("That's what this widget is");
    }
}
