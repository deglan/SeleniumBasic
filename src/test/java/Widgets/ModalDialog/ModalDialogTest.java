package Widgets.ModalDialog;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModalDialogTest extends ModalDialogTestBase{

    private static Stream<Arguments> createUserData() {
        return Stream.of(
                Arguments.of("Name1", "testuser1@example.com", "Password1"),
                Arguments.of("Name2", "testuser2@example.com", "Password2")
        );
    }

    @ParameterizedTest
    @MethodSource("createUserData")
    public void testCreateNewUser(String testName, String testEmail, String testPassword){
        driver.findElement(By.id("create-user")).click();

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        nameInput.clear();
        emailInput.clear();
        passwordInput.clear();

        nameInput.sendKeys(testName);
        emailInput.sendKeys(testEmail);
        passwordInput.sendKeys(testPassword);

        driver.findElement(By.xpath("//button[text()='Create an account']")).click();

        WebElement newRow = driver.findElement(By.xpath("//table[@id='users']//tr[td[text()='" + testName + "']]"));

        assertThat(newRow.findElement(By.xpath(".//td[1]")).getText()).isEqualTo(testName);
        assertThat(newRow.findElement(By.xpath(".//td[2]")).getText()).isEqualTo(testEmail);

    }
}
