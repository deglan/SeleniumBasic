package other.HighSite;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HighSiteTest extends HighSiteTestBase{

    @RepeatedTest(10)
    public void testScrollWithJSExecutor() {
        By submitButtonLocator = By.id("scroll-button");
        highSiteTestSuite.scrollUntilVisible(driver, submitButtonLocator);
        highSiteTestSuite.takeScreenshot(driver, "scroll_button_visible");
    }

    @Test
    public void testScrollWithActions() {
        By submitButtonLocator = By.id("scroll-button");
        highSiteTestSuite.scrollUntilVisibleWithActions(driver, submitButtonLocator);
        highSiteTestSuite.takeScreenshot(driver, "scroll_button_visible");
    }
}
