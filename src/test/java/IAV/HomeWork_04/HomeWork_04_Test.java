package IAV.HomeWork_04;

import IAV.HomeWork_04.HomeWork_04;
import IAV.HomeWork_04.HomeWork_04_Exception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class HomeWork_04_Test {

    @Test
    @DisplayName("Positive test")
    void FirstTest() throws HomeWork_04_Exception {
        HomeWork_04 hw = new HomeWork_04();
        Assertions.assertTrue(hw.getArea(4, 4, 4)>6);
    }

    @ParameterizedTest
    @CsvSource({ "4, 6, 4", "2, 4, 4"})
    @DisplayName("Positive test with parameters")
    void paramTest(int sideA, int sideB, int sideC) throws HomeWork_04_Exception {
        HomeWork_04 hw = new HomeWork_04();
        Assertions.assertTrue(hw.getArea(sideA, sideB, sideC)>0);
    }

    @ParameterizedTest
    @CsvSource({ "3, 7, 3", "-1, 4, 4"})
    @DisplayName("Exception test")
    void throwTest(int sideA, int sideB, int sideC) throws HomeWork_04_Exception{
        HomeWork_04 hw = new HomeWork_04();
        Assertions.assertThrows(HomeWork_04_Exception.class,()->hw.getArea(sideA, sideB, sideC));
    }
}
