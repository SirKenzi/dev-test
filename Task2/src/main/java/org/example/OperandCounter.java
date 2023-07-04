package org.example;

import lombok.RequiredArgsConstructor;

/**
 * Represents the amount of times each operand had been provided.
 * These operands represent a unique pair of operands that result in a given sum.
 */
@RequiredArgsConstructor
public class OperandCounter implements Comparable<OperandCounter>{

    private final Integer operand;
    private final Integer sum;

    private int counterA;
    private int counterB;
    private boolean switcher;

    public Integer getOperand() {
        return operand;
    }

    public int getCounterA() {
        return counterA;
    }

    public int getCounterB() {
        return counterB;
    }

    public void increase(int operand){
        if( (this.getOperand() * 2) == sum) {
            if( switcher){
                counterA++;
            } else {
                counterB++;
            }
            switcher = !switcher;
        } else if (getOperand().equals(operand)){
            counterA++;
        } else{
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
            result.append(getOperand()).append(" ").append(sum-getOperand()).append("\n");
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(OperandCounter o) {
        return this.getOperand().compareTo(o.getOperand());
    }
}
