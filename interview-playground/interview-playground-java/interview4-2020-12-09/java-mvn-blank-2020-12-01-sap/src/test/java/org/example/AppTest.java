package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        int[] input1 = new int[]{1, -1, 3, 2, 10, 7, 3, 4};

        int result1 = App.sumEvenNums(input1, 0, 0);

        assertEquals(16, result1);
    }
}
