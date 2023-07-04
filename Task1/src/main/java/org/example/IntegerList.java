package org.example;

import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public record IntegerList(List<Long> list) {

    public static IntegerList from(String text) {
        List<Long> list = TextToNumberListMapper.map(text);
        return new IntegerList(list);
    }

    public Result evaluate() {
        List<Long> evaluatedList = list.stream()
                .distinct()
                .sorted()
                .toList();

        return Result.builder()
                .evaluatedList(evaluatedList)
                .initialCount(list.size())
                .build();
    }


    @Builder
    public record Result(List<Long> evaluatedList, long initialCount) {

        @Override
        public String toString() {
            return evaluatedList.stream().map(Object::toString).collect(Collectors.joining(" ")) +
                    "\n" +
                    "count: " + initialCount + "\n" +
                    "distinct: " + evaluatedList.size() + "\n" +
                    "min: " + evaluatedList.size() + "\n" +
                    "max: " + evaluatedList.size();
        }

    }
}
