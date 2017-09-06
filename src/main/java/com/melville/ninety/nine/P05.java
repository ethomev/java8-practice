package com.melville.ninety.nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class P05 {
    public static List<Integer> reverse(final List<Integer> numbers) {
        List<Integer> reversed = new ArrayList<>();
        for(int i = numbers.size()-1;i>=0;i--){
            reversed.add(numbers.get(i));
        }
        return reversed;
    }

    public static List<Integer> reverseStack(final List<Integer> numbers){
        Stack<Integer> integerStack = new Stack<>();
        for(Integer integer: numbers){
            integerStack.push(integer);
        }
        return integerStack.stream().collect(Collectors.toList());
    }

    public static List<Integer> reverseCollections(List<Integer> numbers){
        Collections.reverse(numbers);
        return numbers;
    }
}
