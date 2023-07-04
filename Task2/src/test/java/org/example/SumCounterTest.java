package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class SumCounterTest {

    @Test
    void testSumCounterGeneration(){
        Map<OperandPair, SumCounter> sumCounterMap = SumCounter.generate(2);
        Map<OperandPair, SumCounter> sumCounterMap2 = SumCounter.generate(120);
        Assertions.assertEquals(2, sumCounterMap.values().size());
        Assertions.assertEquals(61, sumCounterMap2.values().size());
    }

    @Test
    void testSumCounterToString(){
        Map<OperandPair, SumCounter> sumCounterMap = SumCounter.generate(2);

        List<SumCounter> sumCounterList = sumCounterMap.values().stream().toList();
        sumCounterList.get(1).increase(1);
        sumCounterList.get(1).increase(1);

        String result1 = sumCounterList.get(0).toString();
        String result2 = sumCounterList.get(1).toString();

        Assertions.assertEquals("", result1);
        Assertions.assertEquals("1 1\n", result2);
    }
}
