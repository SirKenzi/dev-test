package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("java:S106")
public class Main {
    public static void main(String[] args) throws IOException {
        long input = Long.parseLong(readInput());
        GraphResolver graphResolver = new GraphResolver();
        while( input-- > 0 ){
            graphResolver.addEdge(edgeFromString(readInput()));
        }
        System.out.println(graphResolver.getGraphsAmount());
    }

    public static String readInput() throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferReader.readLine();
    }

    public static GraphResolver.Edge edgeFromString(String text){
        String[] tokens = text.split(" ");
        int pointA = Integer.parseInt(tokens[0]);
        int pointB = Integer.parseInt(tokens[1]);
        return new GraphResolver.Edge(pointA, pointB);
    }
}