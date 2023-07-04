package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OperandCounterEvaluatorTest {

    @Test
    void testNumberEvaluation(){
        int desiredSum = 13;
        String input = "1 2 10 7 5 3 6 6 13 0";
        List<OperandCounter> sumCounters = Evaluator.evaluate(desiredSum, input);

        Assertions.assertEquals(3, sumCounters.size());
        Assertions.assertEquals(1, sumCounters.get(0).getCounterA());
        Assertions.assertEquals(1, sumCounters.get(0).getCounterB());
        Assertions.assertEquals(1, sumCounters.get(1).getCounterA());
        Assertions.assertEquals(1, sumCounters.get(1).getCounterB());
        Assertions.assertEquals(2, sumCounters.get(2).getCounterA());
        Assertions.assertEquals(1, sumCounters.get(2).getCounterB());
    }

    @Test
    void testNumberEvaluation2(){
        int desiredSum = 60;
        String input = "59 1 1 30 30 22 38 38 38 38 40 20 7 53 11 49";
        List<OperandCounter> sumCounters = Evaluator.evaluate(desiredSum, input);

        Assertions.assertEquals(6, sumCounters.size());
    }

    @Test
    void testNonstandardEvaluation(){
        int desiredSum = 13;
        String input = "1 txt 2 10 7 5 3 6ax 6 13 0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Evaluator.evaluate(desiredSum, input));
    }

}
