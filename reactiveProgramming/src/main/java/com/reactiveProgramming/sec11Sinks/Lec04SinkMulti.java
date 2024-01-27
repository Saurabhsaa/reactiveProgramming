package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {

    public static void main(String[] args) {
        // this will be used to create flux
        Sinks.Many<Object> sinks = Sinks.many().multicast().onBackpressureBuffer();

        //this will be used by subscribers to get data
        Flux<Object> flux = sinks.asFlux();

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("suman"));

        sinks.tryEmitNext("Hi");
        sinks.tryEmitNext("How are you ");

        flux.subscribe(Util.subscriber("mike"));
        sinks.tryEmitNext("?");

    }
}
