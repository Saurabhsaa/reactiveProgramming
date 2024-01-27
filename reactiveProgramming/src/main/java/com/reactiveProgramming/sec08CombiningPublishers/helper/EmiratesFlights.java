package com.reactiveProgramming.sec08CombiningPublishers.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class EmiratesFlights {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1,7))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates "+Util.faker().random().nextInt(600,1100))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
