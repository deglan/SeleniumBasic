package Widgets.Accordion;

import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccordionTest extends  AccordionTestBase{

    @RepeatedTest(10)
    public void testAccordionText() {
        List<WebElement> accordionHeaders = driver.findElements(By.cssSelector("#accordion > h3.ui-accordion-header"));
        for (WebElement header : accordionHeaders) {
            header.click();
            WebElement contentDiv = wait.until(ExpectedConditions.visibilityOf(header.findElement(By.xpath("following-sibling::div"))));
            System.out.println(contentDiv.getText());
        }
    }
}
