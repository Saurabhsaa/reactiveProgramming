package com.reactiveProgramming.sec01;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        //just method to be used only when we have data
        //Mono<String> monoString = Mono.just(getName());

        //using supplier to generate mono and since mono is leazy so once the subs
        //subscribe method is called then only getName will be called .
        Mono<String> monoString = Mono.fromSupplier(()->getName());
        monoString.subscribe(Util.onNext());

        //we can use callable also to get mono
        Callable<String> callable = ()->getName();
        Mono<String> monoStringCallable = Mono.fromCallable(callable);
        monoStringCallable.subscribe(Util.onNext());

    }

    public static String getName(){
        System.out.println("Generating Name");
        return Util.faker().name().firstName();
    }
}
