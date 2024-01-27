package com.reactiveProgramming.sec08CombiningPublishers;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05CombineLatest {

    public static void main(String[] args) {
        Flux.combineLatest(getString(),getNumber(),(s,i)->s+i)
                .subscribe(Util.subscriber());

        Util.sleepThred(10);
    }

    private static Flux<String> getString(){
        return Flux.just("A","B","C","D").delayElements(Duration.ofMillis(500));
    }

    private static Flux<Integer> getNumber(){
        return Flux.just(1,2,3).delayElements(Duration.ofSeconds(2));
    }
}
