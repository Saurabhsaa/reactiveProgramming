package com.reactiveProgramming.sec08CombiningPublishers.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    List<String> cachedNames = new ArrayList<>();

    public Flux<String> generateName(){
        return Flux.generate(synchronousSink -> {
            System.out.println("Generating Fresh Name");
            Util.sleepThred(1);
            String name = Util.faker().name().firstName();
            synchronousSink.next(name);
            cachedNames.add(name);
        }).cast(String.class).startWith(cachedNames);
    }

    public Flux<String> cachedNames(){
        return Flux.fromIterable(cachedNames);
    }

}
