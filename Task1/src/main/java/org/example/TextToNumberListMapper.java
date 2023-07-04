package org.example;

import java.util.Arrays;
import java.util.List;

public class TextToNumberListMapper {

    private TextToNumberListMapper(){}

    private static final String SEPARATOR = " ";

    public static List<Long> map(String string){
        return Arrays.stream(string.split(SEPARATOR)).map(Long::valueOf).toList();
    }
}
