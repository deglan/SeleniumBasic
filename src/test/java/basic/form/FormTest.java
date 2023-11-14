package basic.form;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormTest extends FormTestBase {

    @RepeatedTest(10)
    public void shouldFillFormWithSuccess() {
        FillForm fillFrom = new FillForm(getDriver());
        fillFrom.fillForm();

        WebElement successMessage = getDriver().findElement(By.id("validator-message"));
        Assertions.assertThat(successMessage.getText()).isEqualTo("Form send with success");
    }

//    @RepeatedTest(10)
//    public void shouldDownloadFile() {
//        FileDownloadHelper fileDownloadHelper = new FileDownloadHelper(getDriver());
//        int fileCount = fileDownloadHelper.getFileCountInDirectory(downloadPath);
//        fileDownloadHelper.clickDownloadButton();
//
//        fileDownloadHelper.waitForDownloadCompletion(downloadPath, fileCount);
//
//        int updatedFileCount = fileDownloadHelper.getFileCountInDirectory(downloadPath);
//        Assertions.assertThat(updatedFileCount).isEqualTo(fileCount + 1);
//        boolean containsFile = fileDownloadHelper.doesFileExistInDirectory(downloadPath, "test-file-todownload.xlsx");
//        Assertions.assertThat(containsFile).isTrue();
//    }
}
