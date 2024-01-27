package com.reactiveProgramming.sec02FLux;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1,2,3);

        integerFlux.subscribe(i-> System.out.println("Sub1 "+i));
        integerFlux.subscribe(i-> System.out.println("Sub2 "+i));

        Flux<Integer> evenFlux = integerFlux.filter(i->i%2==0);

        evenFlux.subscribe(i -> System.out.println("Sub3 "+i));

    }

}
