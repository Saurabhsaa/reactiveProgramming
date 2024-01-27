package com.reactiveProgramming.sec08CombiningPublishers;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02Concat {

    public static void main(String[] args) {
        Flux<String> producer1 =  Flux.just("a","b");
        Flux<String> producer2 = Flux.just("c","d","e");
        Flux<String> producer3 = Flux.error(()->new RuntimeException("oops"));

        Flux<String> producer = producer2.concatWith(producer1);
        Flux<String> producer4 = Flux.concat(producer1,producer2);
        Flux<String> producer5 = Flux.concatDelayError(producer1,producer3,producer2);


//        producer.subscribe(Util.subscriber());
//        producer3.subscribe(Util.subscriber());

        //used separate threads for the same purpose
        producer.subscribeOn(Schedulers.boundedElastic()).subscribe(Util.subscriber("ss"));
        producer3.subscribeOn(Schedulers.boundedElastic()).subscribe(Util.subscriber("sa"));
        producer5.subscribeOn(Schedulers.boundedElastic()).subscribe(Util.subscriber("stalin"));
        //making main thread to sleep for 5 sec
        Util.sleepThred(5);

    }
}
