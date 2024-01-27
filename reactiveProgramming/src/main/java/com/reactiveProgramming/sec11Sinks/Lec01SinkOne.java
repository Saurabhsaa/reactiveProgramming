package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec01SinkOne {

    public static void main(String[] args) {
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono().delayElement(Duration.ofSeconds(2));

        mono.subscribe(Util.subscriber("sam"));

        sink.tryEmitValue("1");
        System.out.println("Value Emitted");

        Util.sleepThred(3);
    }

}
