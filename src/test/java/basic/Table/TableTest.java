package basic.Table;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TableTest extends TableTestBase {

    @RepeatedTest(10)
    public void shouldCheckTableWithSwitzerlandAndHeight() {
        tableCheck.checkTableWithSwitzerlandAndHeight(driver);
    }
}
