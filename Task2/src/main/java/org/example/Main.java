package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@SuppressWarnings("java:S106")
public class Main {
    public static void main(String[] args) throws IOException {
        String input = readInput();
        Collection<SumCounter> sumCounters = SumCounterEvaluator.evaluate(13, input);
        sumCounters.forEach(System.out::println);
    }

    public static String readInput() throws IOException{
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferReader.readLine();
    }
}