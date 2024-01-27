package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {
        //range = map + filter
        Flux.range(0,10)
                .handle((integer,synchronousSynk)->{
                    if(integer%2 == 0)
                        synchronousSynk.next(integer);
                }).subscribe(Util.subscriber());
    }

}
