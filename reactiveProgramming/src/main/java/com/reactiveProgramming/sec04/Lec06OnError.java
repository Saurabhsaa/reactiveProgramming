package com.reactiveProgramming.sec04;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

    public static void main(String[] args) {
        Flux.range(0,10)
                .log()
                .map(i->10/(5-i))
//                .onErrorReturn(-1) //returns hard coded value and the process goes to completed state
//                .onErrorResume(error -> fallBack()) // returns a fallback Mono<Object> and the process gets completed after error
                .onErrorContinue((err,obj) -> {
                    System.out.println("error "+err +"with object "+obj);
                }) //with error will get error instance and object on which error happened but the process will continue
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallBack(){
        return Mono.fromSupplier(()->Util.faker().random().nextInt(100,200));
    }

}
