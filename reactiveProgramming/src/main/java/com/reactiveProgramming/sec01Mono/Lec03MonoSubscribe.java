package com.reactiveProgramming.sec01Mono;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> integerMono = Mono.just(1);
        integerMono.subscribe(data -> System.out.println(data),
                                err -> err.getMessage(),
                                () -> System.out.println("Completed"));

        Mono<Integer> integerMonoWithError = Mono.just("Suman")
                                        .map(String::length)
                                        .map(len -> len/0);

        //exception handled case
        integerMonoWithError.subscribe(data -> System.out.println(data),
                                        err -> System.out.println(err.getMessage()),
                                        () -> System.out.println("Completed"));
        //unhandled exception case
        integerMonoWithError.subscribe(data -> System.out.println(data));

        //use utility methods
        integerMonoWithError.subscribe(Util.onNext(),
                                    Util.onError(),
                                    Util.onComplete());
    }
}
