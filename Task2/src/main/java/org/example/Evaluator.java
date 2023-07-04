package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Evaluator {

    public static List<OperandCounter> evaluate(int sum, String input){
        List<Integer> operands = TextToNumberListMapper.map(input);
        OperandCounters operandCounters = OperandCounters.generate(sum);
        operands.forEach(operandCounters::increaseOperandCounter);
        return operandCounters.listValues();
    }

}
