package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String name = Util.faker().country().name();
            synchronousSink.next(name);
            if(name.equalsIgnoreCase("india")){
                synchronousSink.complete();
            }
        })
        .subscribe(Util.subscriber());
    }
}
