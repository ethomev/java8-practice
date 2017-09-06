package com.melville.ninety.nine;

import java.util.List;
import java.util.NoSuchElementException;

public class P02 {
    public static Integer secondLast(final List<Integer> numbers) {
        if(numbers.size() < 2){
            throw new NoSuchElementException();
        }
        return numbers.get(numbers.size() - 2);
    }
}
