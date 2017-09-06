package com.melville.basic.date.time;

import java.time.Clock;
import java.time.Instant;

public class MyClock {

    public static void main(String[] args){
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();

        System.out.println(instant.toString());
    }
}
