package com.reactiveProgramming.sec02FLux;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepThred(5);
    }

}
