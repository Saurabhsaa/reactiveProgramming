package com.reactiveProgramming.sec02FLux;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("Suman");
        Flux<String> stringFlux = Flux.from(stringMono);

        stringFlux.subscribe(Util.onNext());
    }
}
