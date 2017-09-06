package com.melville.basic.method.reference;

import java.util.List;
import java.util.ArrayList;

public class Basic {
    public static void main(String args[]){
        List<String> names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        Basic basic = new Basic();

        names.forEach(basic::print);
    }


    public void print(String element){
        System.out.println(element);
    }
}
