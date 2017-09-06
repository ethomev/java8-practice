package com.melville.basic.collections.lambda;

public class Scope {

    static String salutation = "Hello! ";

    static int outerStaticNum;
    int outerNum;
    int num = 4;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            num =3;
            return String.valueOf(from);
        };
    }

    public static void main(String args[]){
//        GreetingService greetService1 = message ->
//                System.out.println(salutation.concat( message));
//        greetService1.sayMessage("Mahesh");
//        GreetingService greetService2 = message ->
//                System.out.println(salutation.concat( message));
//        greetService2.sayMessage("Mahesh");

        final int num = 3;

        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(num);

        stringConverter.convert(2);     // 3

    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
