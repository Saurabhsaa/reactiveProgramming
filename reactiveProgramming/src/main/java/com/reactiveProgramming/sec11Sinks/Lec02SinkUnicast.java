package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {

    public static void main(String[] args) {

        //handle through which we will push data
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        //handle through which subscriber will receive data
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));
        //since sink is unicast so only one subscriber is allowed
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("Hi , ");
        sink.tryEmitNext("How are you ?");

    }

}
