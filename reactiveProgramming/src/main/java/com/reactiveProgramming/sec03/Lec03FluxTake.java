package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {
        Flux.range(0,10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }

}
