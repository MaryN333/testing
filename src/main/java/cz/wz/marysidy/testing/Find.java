package cz.wz.marysidy.testing;

import java.util.List;
import java.util.NoSuchElementException;

public class Find {
    public Double findMatching(List<Double> list, Double lowerLimit, Double upperLimit) {
        if (list.isEmpty() || list == null) {
            throw new IllegalArgumentException("The list can't be empty.");
        }
        if (lowerLimit <= 0 || upperLimit <= 0) {
            throw new IllegalArgumentException("Limits must be positive decimal numbers.");
        }
        if (lowerLimit > upperLimit) {
            throw new IllegalArgumentException("The lower limit must be less than the upper limit.");
        }
        for (Double item : list) {
            if (item >= lowerLimit && item <= upperLimit) {
                return item;
            }
        }
        throw new NoSuchElementException("No matching element found in the specified interval");
    }
}
