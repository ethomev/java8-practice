package com.melville.bb.jvm;

public class Frames {

    private static final String MESSAGE = "Hello there";

    public static void main(String[] args){
        Frames frames = new Frames();
        frames.sayHello();
        double result = frames.compute(1,2,"+");
        System.out.println("Result is: "+result);
    }

    private double compute(final double opA, final double opB, final String operation) {
        double result = -1;
        if(operation.equals("+")){
            result = add(opA, opB);
        } else if (operation.equals("-")){
            result = subtract(opA, opB);
        }
        return result;
    }

    public void sayHello() {
        System.out.println(MESSAGE);
    }

    private double add(double opA, double opB){
        double result = opA + opB;
        return result;
    }

    private double subtract(double opA, double opB){
        return opA - opB;
    }

}
