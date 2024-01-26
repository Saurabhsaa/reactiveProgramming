package com.reactiveProgramming.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.*;

public class OrderService {

    private static Map<Integer, List<PurchageOrder>> db = new HashMap<>();

    static {
        List<PurchageOrder> purchageOrders1 = Arrays.asList(
                new PurchageOrder(1),
                new PurchageOrder(1),
                new PurchageOrder(1)
        );

        List<PurchageOrder> purchageOrders2 = Arrays.asList(
                new PurchageOrder(2),
                new PurchageOrder(2)
        );

        db.put(1,purchageOrders1);
        db.put(2,purchageOrders2);
    }

    public static Flux<PurchageOrder> getOrders(int userId){
        return Flux.create((FluxSink<PurchageOrder> purchageOrderFluxSink) -> {
            db.get(userId).forEach(item->purchageOrderFluxSink.next(item));
            purchageOrderFluxSink.complete();
        }).delayElements(Duration.ofSeconds(1));
    }

}
