package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.sec09Batching.helper.OrderProcessor;
import com.reactiveProgramming.sec09Batching.helper.OrderService;
import com.reactiveProgramming.sec09Batching.helper.PurchageOrder;
import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {
    public static void main(String[] args) {
        Map<String, Function<Flux<PurchageOrder>, Flux<PurchageOrder>>> map =
                Map.of(
                        "Kids",OrderProcessor.kidsProcessing(),
                        "Automotive",OrderProcessor.automotiveProcessing()
                );

        Set<String> keys = map.keySet();

        OrderService.orderStream()
                .filter(od -> keys.contains(od.getCategory()))
                .groupBy(od -> od.getCategory())
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepThred(180);
    }
}
