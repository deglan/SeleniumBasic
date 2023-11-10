package Widgets.DatePicker;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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


public class DatePickerTest extends DatePickerTestBase {


    @RepeatedTest(10)
    public void testSelectDates() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayNextMonth = today.plusMonths(1).withDayOfMonth(1);

        datePickerService.selectDate(today);
        datePickerService.assertSelectedDate(today);

        datePickerService.selectDate(firstDayNextMonth);
        datePickerService.assertSelectedDate(firstDayNextMonth);
    }


}
