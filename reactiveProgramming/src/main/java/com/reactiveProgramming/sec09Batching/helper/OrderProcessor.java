package com.reactiveProgramming.sec09Batching.helper;

import reactor.core.publisher.Flux;

import java.util.function.Function;

public class OrderProcessor {

    public static Function<Flux<PurchageOrder>,Flux<PurchageOrder>> automotiveProcessing(){
        return flux -> {
            flux
            .doOnNext(fl -> fl.setPrice(fl.getPrice()*1.1))
            .doOnNext(fl -> fl.setItem("{{ "+fl.getItem()+ "}}"));
            return flux;
        };
    }

    public static Function<Flux<PurchageOrder>,Flux<PurchageOrder>> kidsProcessing(){
        return flux ->
             flux.doOnNext(pd -> pd.setPrice(pd.getPrice()*0.5))
                    .flatMap(pd -> Flux.just(pd,getFreeItemForKids()));

    }

    public static PurchageOrder getFreeItemForKids(){
        PurchageOrder purchageOrder = new PurchageOrder();
        purchageOrder.setItem("FREE - "+purchageOrder.getItem());
        purchageOrder.setPrice(0);
        purchageOrder.setCategory("Kids");
        return purchageOrder;
    }

}
