package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverlappingAndDrop {

    public static void main(String[] args) {
        eventStream()
                .buffer(3,1)
//                .buffer(3,5)
                .subscribe(Util.subscriber());

        Util.sleepThred(15);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i->"item"+i);
    }

}
