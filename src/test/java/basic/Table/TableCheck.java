package basic.Table;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableCheck {

    public void checkTableWithSwitzerlandAndHeight(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        List<String> mountainInfo = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.cssSelector("td"));
            String country = columns.get(2).getText();
            String height = columns.get(3).getText();

            if (country.contains("Switzerland") && !height.isEmpty()) {
                int mountainHeight = Integer.parseInt(height.replace(" m", ""));
                if (mountainHeight > 4000) {
                    String peak = columns.get(0).getText();
                    String mountainRange = columns.get(1).getText();
                    mountainInfo.add("Peak: " + peak + ", Mountain range: " + mountainRange + ", Height: " + mountainHeight);
                }
            }

        }
        for (String info : mountainInfo) {
            System.out.println(info);
        }
        Assertions.assertThat(mountainInfo.size()).isGreaterThan(0);
    }
}

