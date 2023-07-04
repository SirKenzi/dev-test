package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("java:S106")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferReader.readLine();
        IntegerList.Result result = IntegerList.from(input).evaluate();
        System.out.println(result);
    }

}