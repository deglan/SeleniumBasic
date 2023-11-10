package basic.Iframes;

import org.junit.jupiter.api.RepeatedTest;

public class IframesTest extends IframesTestBase {

    @RepeatedTest(10)
    public void testFillingFirstIframeForm() {
        fillIframes.fillUpFirstIframe(driver);
    }

    @RepeatedTest(10)
    public void testFillingSecondIframeForm() {
        fillIframes.fillUpSecondIframe(driver);
    }


}
