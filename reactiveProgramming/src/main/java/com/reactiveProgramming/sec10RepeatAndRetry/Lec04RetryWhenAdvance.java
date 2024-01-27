package com.reactiveProgramming.sec10RepeatAndRetry;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class Lec04RetryWhenAdvance {

    public static void main(String[] args) {
        orderService("98450")
                .doOnError((err)-> System.out.println(err.getMessage()))
                .retryWhen(Retry.from(flux ->
                            flux.doOnNext((rs)->{
                                System.out.println(rs.retryContextView());
                                System.out.println(rs.failure());
                                })
                                    .handle((rs, synchronousSink) -> {
                                        if(rs.failure().getMessage().contains("500")){
                                            synchronousSink.next(1);
                                        }else{
                                            synchronousSink.error(rs.failure());
                                    }
                                })
                                .delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(Util.subscriber());

        Util.sleepThred(30);
    }

    public static Mono<String> orderService(String ccNo){
        return Mono.fromSupplier(()->{
            paymentService(ccNo);
            return Util.faker().idNumber().valid();
        });
    }

    //payment service
    public static void paymentService(String ccNo){
        int random  = Util.faker().random().nextInt(1,10);
        if(random < 8)
             throw  new RuntimeException("500");
        else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
