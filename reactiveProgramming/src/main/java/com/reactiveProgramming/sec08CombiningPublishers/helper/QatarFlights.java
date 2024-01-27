package com.reactiveProgramming.sec08CombiningPublishers.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class QatarFlights {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1,5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatat " + Util.faker().random().nextInt(100,999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
