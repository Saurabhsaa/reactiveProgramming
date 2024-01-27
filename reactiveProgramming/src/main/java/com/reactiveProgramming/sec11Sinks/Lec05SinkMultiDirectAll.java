package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec05SinkMultiDirectAll {
    public static void main(String[] args) {
//        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("mike"));
        flux.delayElements(Duration.ofMillis(800)).subscribe(Util.subscriber("same"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepThred(60);
    }
}
