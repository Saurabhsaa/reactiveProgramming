package com.reactiveProgramming.sec02;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxToMono {
    public static void main(String[] args) {
        Flux.range(0,10)
                .filter(i->i>7)
                .next()
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
