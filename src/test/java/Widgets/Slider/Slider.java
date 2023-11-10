package Widgets.Slider;

import org.junit.jupiter.api.RepeatedTest;

public class Slider extends SliderTestBase {


    @RepeatedTest(10)
    public void testSliderMoves() {
        move.moveSlider(driver, 50);
        move.moveSlider(driver, 80);
        move.moveSlider(driver, 20);
        move.moveSlider(driver, 0);
    }
}


