package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerListTest {

    @Test
    void testEvaluationResultForOnlyNumbers(){
        String input = "3 2 7 3 4 5 10 333333 10 4";

        IntegerList.Result result = IntegerList.from(input).evaluate();

        Assertions.assertEquals(10, result.initialCount());
        Assertions.assertEquals(7, result.evaluatedList().size());
        Assertions.assertEquals(2, result.evaluatedList().get(0));
        Assertions.assertEquals(333333, result.evaluatedList().get(result.evaluatedList().size()-1));
    }

    @Test
    void testEvaluationResultForNonStandardInput(){
        String input = "3 tx 2 7 3; 4 5 10 333333 10 4";
        Assertions.assertThrows(IllegalArgumentException.class, () -> IntegerList.from(input));
    }

    @Test
    void testToStringOutput(){
        String input = "3 2 7 3 4 5 10 333333 10 4";

        IntegerList.Result result = IntegerList.from(input).evaluate();
        Assertions.assertEquals("""
                2 3 4 5 7 10 333333
                count: 10
                distinct: 7
                min: 7
                max: 7""", result.toString());

    }
}
