package Widgets.DatePicker;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AllArgsConstructor
public class DatePickerService {

    private final WebDriver driver;

    public void selectDate(LocalDate date) {
        navigateToDate(date);
        selectDay(date);
    }

    public void navigateToDate(LocalDate date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("datepicker")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-title")));

        while (!isDisplayedMonthYear(date)) {
            if (shouldNavigateForward(date)) {
                wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-next"))).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-prev"))).click();
            }
        }
    }

    public boolean shouldNavigateForward(LocalDate targetDate) {
        String displayedMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
        YearMonth displayedYearMonth;

        try {
            displayedYearMonth = YearMonth.parse(displayedMonthYear, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return false;
        }

        YearMonth targetYearMonth = YearMonth.from(targetDate);
        return targetYearMonth.isAfter(displayedYearMonth);
    }

    public boolean isDisplayedMonthYear(LocalDate date) {
        String displayedMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
        try {
            YearMonth displayedYearMonth = YearMonth.parse(displayedMonthYear, formatter);
            return displayedYearMonth.getMonth() == date.getMonth() && displayedYearMonth.getYear() == date.getYear();
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return false;
        }
    }

    public void selectDay(LocalDate date) {
        WebElement datepicker = driver.findElement(By.id("ui-datepicker-div"));
        if (!datepicker.isDisplayed()) {
            driver.findElement(By.id("datepicker")).click();
        }

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[contains(@class, 'ui-state-default')]"));
        for (WebElement day : days) {
            if (day.getText().equals(String.valueOf(date.getDayOfMonth()))) {
                day.click();
                break;
            }
        }
    }

    public void assertSelectedDate(LocalDate expectedDate) {
        String selectedDateStr = driver.findElement(By.id("datepicker")).getAttribute("value");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate selectedDate = LocalDate.parse(selectedDateStr, formatter);

        assertThat(selectedDate)
                .withFailMessage("Selected date is not as expected. Expected: %s, but was: %s", expectedDate, selectedDate)
                .isEqualTo(expectedDate);
    }
}
