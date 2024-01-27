package com.reactiveProgramming.sec07BackpressureOverFlow;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec05BufferWithSize {

    public static void main(String[] args) {
        List<Object> droppedList = new ArrayList<>();
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 400 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println(" Produced : "+i);
                        Util.sleepThredMillSec(1);
                    }
                    fluxSink.complete();
                }).onBackpressureBuffer(20,i->droppedList.add(i))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext((i)-> Util.sleepThredMillSec(10))
                .subscribe(Util.subscriber());

        Util.sleepThred(10);
        System.out.println(droppedList);
    }

}
