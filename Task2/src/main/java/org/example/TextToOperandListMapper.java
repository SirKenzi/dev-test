package org.example;

import java.util.Arrays;
import java.util.List;

public class TextToOperandListMapper {

    private TextToOperandListMapper(){}

    private static final String SEPARATOR = " ";

    public static List<OperandPair> map(String string){
        return Arrays.stream(string.split(SEPARATOR))
                .map(Integer::valueOf)
                .map(OperandPair::fromSingleOperand)
                .toList();
    }
}
