package com.melville.basic.streams;

import java.util.stream.IntStream;

public class NumberStreams {

    public static void main(String[] args){

        IntStream.of(1,3,2,4,5,6,7,9).filter(num -> num%2 ==0).sorted().forEach(System.out::println);
    }
}
