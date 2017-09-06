package com.melville.rxjava;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class Basic {
    public static void main(String[] args) throws InterruptedException {
//        myOwnAttempt();

//        events();

        Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

        Observable<Long> clock = Observable.merge(
                slow.filter(tick-> isSlowTickTime()),
                fast.filter(tick-> !isSlowTickTime())
        );

        clock.subscribe(tick -> System.out.println(new Date()));
        Thread.sleep(60_000);
    }

    private static boolean isSlowTickTime() {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY ||
                LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static long start = System.currentTimeMillis();
    public static Boolean isSlowTime() {
        return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
    }

    private static void events() {
        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dogs"
        );

        Observable.from(words)
                .flatMap(word -> Observable.from(word.split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count)->String.format("%2d. %s", count, string))
                .subscribe(word->System.out.println(word));
    }

    private static void myOwnAttempt() {
        List<Band> bands = new ArrayList<>();
        bands.add(new Band("Metallica", "Metal"));
        bands.add(new Band("Pantera", "Metal"));
        bands.add(new Band("Boyzone", "Pop"));
        bands.add(new Band("Lamb of God", "Metal"));
        Observable.from(bands).subscribe(new Action1<Band>() {
            @Override
            public void call(final Band band) {
                if(band.genre.equalsIgnoreCase("metal")){
                    System.out.println(String.format("%s are class", band.name));
                } else {
                    System.out.println(String.format("%s are shite", band.name));
                }
            }
        });
    }

    private static class Band {
        private final String name;
        private final String genre;

        public Band(final String name, final String genre){
            this.name = name;
            this.genre = genre;
        }
    }
}
