package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec06SinkReplay {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("Hi");
        sink.tryEmitNext("How are you");

        flux.subscribe(Util.subscriber("mike"));
        flux.subscribe(Util.subscriber("same"));

        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("jack"));

        Util.sleepThred(60);
    }

}
