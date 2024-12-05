package cz.wz.marysidy.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FindMatchingTest {
    Find find;
    List<Double> testList;

    @BeforeEach
    void setUp(){
        find = new Find();
        testList = List.of(10.0, 15.45, 5.811, 175.0);
    }

    @AfterEach
    void tearDown(){}

    @Test
    public void middleTest() {
        Double testResult = find.findMatching(testList, 4.0, 9.3);
        Assertions.assertEquals(5.811, testResult);
    }

    @Test
    public void emptyTest() {
        List<Double> emptyList = new ArrayList<>();
        Exception actual = Assertions.assertThrows(
                IllegalArgumentException.class, () -> find.findMatching(emptyList, 10.0, 12.0)
        );
        Assertions.assertEquals("The list can't be empty.", actual.getMessage());
    }

    @Test
    public void firstNumberTest() {
        List<Double> myList = List.of(12.0, 8.126, 6.0);
        double expected = 12.0;
        double actual = find.findMatching(myList, 11.0, 12.6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void severalNumbersInLimitTest() {
        List<Double> myList = List.of(12.0, 8.126, 9.0, 158.0, 6.0);
        double expected = 8.126;
        double actual = find.findMatching(myList, 8.0, 10.0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lastNumberTest() {
        List<Double> myList = List.of(12.0, 8.126, 9.0, 158.0, 6.0);
        double expected = 6.00;
        double actual = find.findMatching(myList, 5.0, 6.0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void positiveLowerLimitTest() {
        double lowerLimit = 10.0;
        double upperLimit = 12.0;
        double actual = find.findMatching(testList,lowerLimit, upperLimit);
        Assertions.assertTrue(actual >= lowerLimit);
    }

    @Test
    public void positiveUpperLimitTest() {
        double lowerLimit = 10.0;
        double upperLimit = 18.0;
        double actual = find.findMatching(testList,lowerLimit, upperLimit);
        Assertions.assertTrue(actual <= upperLimit);
    }

    @Test
    public void negativeLowerLimitTest() {
        double lowerLimit = -10.0;
        double upperLimit = 12.0;
        Exception actual = Assertions.assertThrows(
                Exception.class, () -> find.findMatching(testList, lowerLimit, upperLimit)
        );
        Assertions.assertEquals("Limits must be positive decimal numbers.", actual.getMessage());
    }

    @Test
    public void negativeUpperLimitTest() {
        double lowerLimit = 10.0;
        double upperLimit = -12.0;
        Exception actual = Assertions.assertThrows(
                IllegalArgumentException.class, () -> find.findMatching(testList, lowerLimit, upperLimit)
        );
        Assertions.assertEquals("Limits must be positive decimal numbers.", actual.getMessage());
    }

    @Test
    public void lessLowerLimitTest() {
        double lowerLimit = 12.0;
        double upperLimit = 10.0;
        Exception actual = Assertions.assertThrows(
                IllegalArgumentException.class, () -> find.findMatching(testList, lowerLimit, upperLimit)
        );
        Assertions.assertEquals("The lower limit must be less than the upper limit.", actual.getMessage());
    }

    @Test
    public void noMatchingTest() {
        double lowerLimit = 200.0;
        double upperLimit = 300.0;
        Exception actual = Assertions.assertThrows(
                NoSuchElementException.class, () -> find.findMatching(testList, lowerLimit, upperLimit)
        );
        Assertions.assertEquals("No matching element found in the specified interval", actual.getMessage());
    }
}
