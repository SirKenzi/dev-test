package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OperandCountersTest {

    @Test
    void testSumCounterGeneration(){
        OperandCounters operandCounters = OperandCounters.generate(2);
        Assertions.assertEquals(0, operandCounters.listValues().size());
    }

    @Test
    void testSumCounterToString(){
        OperandCounters operandCounters = OperandCounters.generate(2);
        operandCounters.increaseOperandCounter(1);
        operandCounters.increaseOperandCounter(1);

        List<OperandCounter> sumCounterList = operandCounters.listValues();

        Assertions.assertEquals(1, sumCounterList.size());
        Assertions.assertEquals("1 1\n", sumCounterList.get(0).toString());
    }
}
