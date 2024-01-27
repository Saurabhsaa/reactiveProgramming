package com.reactiveProgramming.sec05HotAndColdPub.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {

    private Map<String,Integer> db = new HashMap<>();

    public InventoryService(){
        db.put("Kids",100);
        db.put("Automotive",100);
    }

    public Consumer<PurchageOrder> subscribeOrderService(){
        return p -> db.computeIfPresent(p.getCategory(),(k,v)->v-p.getQuantity());
    }

    public Flux<String> inventoryStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(i->db.toString());
    }

}
