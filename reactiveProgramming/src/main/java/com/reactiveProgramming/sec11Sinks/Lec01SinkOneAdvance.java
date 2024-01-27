package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec01SinkOneAdvance {

    public static void main(String[] args) {
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono().delayElement(Duration.ofSeconds(2));

        mono.subscribe(Util.subscriber("sam"));

        mono.subscribe(Util.subscriber("ram"));

        sink.emitValue("Hi", (signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });

        Util.sleepThred(3);

        sink.emitValue("Hello", (signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });

        Util.sleepThred(12);
    }

}
