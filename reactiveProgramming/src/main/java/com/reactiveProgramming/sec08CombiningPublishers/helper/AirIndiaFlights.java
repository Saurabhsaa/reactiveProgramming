package com.reactiveProgramming.sec08CombiningPublishers.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AirIndiaFlights {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1,10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "AirIndia "+Util.faker().random().nextInt(400,900))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
