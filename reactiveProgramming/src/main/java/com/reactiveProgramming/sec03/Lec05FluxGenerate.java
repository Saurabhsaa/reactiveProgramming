package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    //generate supply infinite synchronozedSink and we don't need to use any loops to get continuous data
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("india"))
                synchronousSink.complete();
        })
        .subscribe(Util.subscriber());
    }
}
