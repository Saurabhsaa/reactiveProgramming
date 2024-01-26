package com.reactiveProgramming.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

public class OrderService {

    private Flux<PurchageOrder> flux;

    public Flux<PurchageOrder> orderStream(){
        if(Objects.isNull(flux)){
            flux = getOrderStream();
        }
        return flux;
    }

    //since it is a hot publisher if we invoke it directly everytime we will
    //be generation a new pipeline . To avoid it we can create the pipeline once and return
    //the same pipeline everytime
    private Flux<PurchageOrder> getOrderStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchageOrder())
                .publish()
                .refCount(2);
    }
}
