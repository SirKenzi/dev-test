package org.example;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * Represents the amount of times each operand had been provided.
 * These operands represent a unique pair of operands that result in a given sum.
 */
@RequiredArgsConstructor(access= AccessLevel.PRIVATE)
public class SumCounter {

    private final OperandPair operandPair;

    private int counterA;
    private int counterB;
    private boolean switcher;

    public int getCounterA() {
        return counterA;
    }

    public int getCounterB() {
        return counterB;
    }

    public void increase(int operand){
        if( operandPair.operandA().equals(operandPair.operandB())) {
            if( switcher){
                counterA++;
            } else {
                counterB++;
            }
            switcher = !switcher;
        } else if (operandPair.operandA()  == operand){
            counterA++;
        } else if (operandPair.operandB() == operand){
            counterB++;
        }
    }

    public boolean exist(){
        return Math.min(counterA, counterB) != 0;
    }

    @Override
    public String toString() {
        int min = Math.min(counterA, counterB);
        if( min == 0 ){
            return "";
        }
        int max = Math.max(counterA, counterB);
        StringBuilder result = new StringBuilder();
        for( int i = 0; i < max; i++ ){
            result.append(operandPair.operandA()).append(" ").append(operandPair.operandB()).append("\n");
        }
        return result.toString();
    }

    public static Map<OperandPair, SumCounter> generate(int n){
        Map<OperandPair, SumCounter> sums = new HashMap<>();
        for( int i = 0; i <= n/2; i++){
            OperandPair operandPair = new OperandPair(i, n-i);
            sums.put(operandPair, new SumCounter(operandPair));
        }
        return sums;
    }
}
