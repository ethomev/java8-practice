package com.melville.ninety.nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class P06 {
    public static <T> boolean isPalindrome(final List<T> integers) {
        List<T> reversed = new ArrayList<>(integers);
        Collections.reverse(reversed);
//        for(int i = 0; i<integers.size();i++){
//            if(integers.get(i).equals(reversed.get(i))){
//                continue;
//            }
//            return false;
//        }
//        return true;
        return Objects.equals(integers, reversed);
    }
}
