package com.reactiveProgramming.sec07BackpressureOverFlow;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop {



    public static void main(String[] args) {
        //75% rules applied here as well
        System.setProperty("reactor.bufferSize.small", "16");
        List<Object> droppedItems = new ArrayList<>();
        Flux.create(fluxSink -> {
            for (int i = 0; i < 400; i++) {
                fluxSink.next(i);
                System.out.println(" Produced : "+i);
                Util.sleepThredMillSec(1);
            }
            fluxSink.complete();
        }).onBackpressureDrop(i->droppedItems.add(i))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext((i)-> Util.sleepThredMillSec(10))
                .subscribe(Util.subscriber());

        Util.sleepThred(15);
        System.out.println(droppedItems);
    }

}
