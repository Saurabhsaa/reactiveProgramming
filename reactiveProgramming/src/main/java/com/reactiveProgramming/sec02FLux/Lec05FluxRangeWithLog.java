package com.reactiveProgramming.sec02FLux;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRangeWithLog {

    public static void main(String[] args) {
        Flux.range(2,10)
                .log()
                .map(i-> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }

}
