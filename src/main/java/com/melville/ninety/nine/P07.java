package com.melville.ninety.nine;

import java.util.ArrayList;
import java.util.List;

public class P07 {
    public static <T> List<T> flatten(List<?> list, Class<T> elementType) {
        List<T> flatten = new ArrayList<>();
        list.forEach(e -> {
            if (e instanceof List) {
                flatten.addAll(flatten((List<?>) e, elementType));
            } else {
                flatten.add((T) e);
            }
        });
        return flatten;
    }
}
