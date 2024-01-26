package com.reactiveProgramming.sec04;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRange {

    public static void main(String[] args) {
        Flux.range(0,101)
                .log()
                .limitRate(10,5)
//                .limitRate(10,0) // to fetch 100% data before making new request
                .subscribe(Util.subscriber());
    }

}
