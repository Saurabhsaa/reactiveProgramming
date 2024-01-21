package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec07GenerateWithCounter {

    public static void main(String[] args) {
        Flux.generate(
                ()->1,
                (counter,synchronousSink)->{
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if(counter==10 || country.equalsIgnoreCase("india"))
                        synchronousSink.complete();
                    return counter + 1;
                }).subscribe(Util.subscriber());
    }

}
