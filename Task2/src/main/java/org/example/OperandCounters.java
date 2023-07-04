package org.example;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OperandCounters {

    private final Map<Integer, OperandCounter> firstOperandMap;
    private final Map<Integer, OperandCounter> secondOperandMap;

    public void increaseOperandCounter(int operand){
        if( firstOperandMap.containsKey(operand)){
            firstOperandMap.get(operand).increase(operand);
        } else if (secondOperandMap.containsKey(operand)){
            secondOperandMap.get(operand).increase(operand);
        }
    }

    public List<OperandCounter> listValues(){
        return firstOperandMap.values().stream()
            .filter(OperandCounter::exist)
            .sorted()
            .toList();
    }

    public static OperandCounters generate(int n){
        Map<Integer, OperandCounter> firstOperandMap = new HashMap<>();
        Map<Integer, OperandCounter> secondOperandMap = new HashMap<>();
        for( int i = 0; i <= n/2; i++){
            OperandCounter sumCounter = new OperandCounter(i, n);
            firstOperandMap.put(i, sumCounter);
            secondOperandMap.put(n-i, sumCounter);
        }
        return new OperandCounters(firstOperandMap, secondOperandMap);
    }

}
