package org.example;

/**
 * <p>Represents a unique sum of two operands.</p>
 * <p>It assumes, that the objects will only ever coexist with other objects calculating the same sum.</p>
 * <p>As a result an OperandPair of 3-4 is the same as any other containing 3.</p>
 * @param operandA - first operand of a sum
 * @param operandB - second operand of a sum
 */
public record OperandPair(Integer operandA, Integer operandB) {

    public static OperandPair fromSingleOperand(int operand){
        return new OperandPair(operand, operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        OperandPair that = (OperandPair) o;
        return operandA.equals(that.operandA) || operandA.equals(that.operandB);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
