package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String name ;
            do{
                name = Util.faker().country().name();
                fluxSink.next(name);
            }while (!name.equalsIgnoreCase("india"));
        }).log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());

    }

}
