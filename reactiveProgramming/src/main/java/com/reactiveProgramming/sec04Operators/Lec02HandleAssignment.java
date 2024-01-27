package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

    public static void main(String[] args) {
        Flux.generate((s)-> s.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if(s.equalsIgnoreCase("india"))
                        synchronousSink.complete();
                }).subscribe(Util.subscriber());
    }
}
