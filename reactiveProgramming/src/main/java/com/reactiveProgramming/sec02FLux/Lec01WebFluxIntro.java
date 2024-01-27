package com.reactiveProgramming.sec02FLux;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec01WebFluxIntro {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1,2,4,"Flux", Util.faker().name().fullName());

        flux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

    }

}
