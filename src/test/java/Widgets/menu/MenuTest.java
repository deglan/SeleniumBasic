package Widgets.menu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.Stream;

public class MenuTest extends MenuTestBase {

    private static Stream<Arguments> createUserData() {
        return Stream.of(
                Arguments.of("Name1", "Email1", "Password1"),
                Arguments.of("Name2", "Email2", "Password2")
        );
    }

    @ParameterizedTest
    @MethodSource("createUserData")
    public void testCreateUser(String name, String email, String password) {
        // Navigate through menu
        clickMenu("ui-id-9");
        clickMenu("ui-id-13");
        clickMenu("ui-id-16");

        // Fill out the form
        driver.findElement(By.id("nameField")).sendKeys(name);
        driver.findElement(By.id("emailField")).sendKeys(email);
        driver.findElement(By.id("passwordField")).sendKeys(password);

        driver.findElement(By.id("createAccount")).click();
    }

    private void clickMenu(String id) {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        menu.click();
    }
}
