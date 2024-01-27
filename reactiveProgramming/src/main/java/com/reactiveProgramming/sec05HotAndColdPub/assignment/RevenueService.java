package com.reactiveProgramming.sec05HotAndColdPub.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private Map<String,Double> db = new HashMap<>();

    public RevenueService(){
        db.put("Kids",0.0);
        db.put("Automotive",0.0);
    }

    public Consumer<PurchageOrder> subscribeOrderService(){
        return p -> db.computeIfPresent(p.getCategory(),(k,v)->v+p.getPrice());
    }

    public Flux<String> revenueStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(i->db.toString());
    }


}
