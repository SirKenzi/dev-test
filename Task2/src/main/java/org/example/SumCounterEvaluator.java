package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.NONE)
public class SumCounterEvaluator {

    public static List<SumCounter> evaluate(int sum, String input){
        List<OperandPair> operandPairs = TextToOperandListMapper.map(input);
        Map<OperandPair, SumCounter> sums = SumCounter.generate(sum);

        for( OperandPair operandPair : operandPairs){
            SumCounter counter = sums.get(operandPair);
            if( counter != null ) {
                counter.increase(operandPair.operandA());
            }
        }
        return sums.values().stream()
                .filter(SumCounter::exist)
                .toList();
    }

}
