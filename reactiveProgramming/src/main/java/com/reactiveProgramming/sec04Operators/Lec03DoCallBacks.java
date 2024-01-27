package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallBacks {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("Started producer : ");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            System.out.println("completed ...");

        })
        .doOnComplete(()-> System.out.println("doOnComplete"))
        .doFirst(()-> System.out.println("doFirst 1"))
        .doFirst(()-> System.out.println("doFirst 2"))
        .doOnNext((o)-> System.out.println("doOnNext : "+o))
        .doOnSubscribe((subscription) -> System.out.println("doOnSubscribe 1 : "+subscription))
        .doOnSubscribe((subscription) -> System.out.println("doOnSubscribe 2 : "+subscription))
        .doOnError((err) -> System.out.println("doOnError : "+err.getMessage()))
        .doOnTerminate(()-> System.out.println("doOnTermenate"))
        .doOnCancel(()-> System.out.println("doOnCancle"))
        .doFinally((signalType)-> System.out.println("finally executed 1 ..." + signalType))
        .doOnSubscribe((subscription) -> System.out.println("doOnSubscribe 2 : "+subscription))
        .doOnDiscard(Object.class,o-> System.out.println("doOndiscard "+o))
        .take(3)
        .doFinally((signalType)-> System.out.println("finally executed 2 ..." + signalType))
        .subscribe(Util.subscriber());
    }
}
