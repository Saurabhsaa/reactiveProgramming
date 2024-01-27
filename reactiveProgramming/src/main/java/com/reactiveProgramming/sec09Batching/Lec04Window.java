package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec04Window {

    public static void main(String[] args) {

        generateItem()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(i->consumerFlux(i))
                .subscribe(Util.subscriber());

        Util.sleepThred(20);

    }

    private static Mono<Void> consumerFlux(Flux<String> flux){
        return flux.doOnNext(i-> System.out.println("saving "+ i))
                .doOnComplete(()->{
                    System.out.println("saved this batch");
                    System.out.println("-----------------");
                }).then();
    }

    private static Flux<String> generateItem(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i->"item"+i);
    }

}
