package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Buffer {

    public static void main(String[] args) {
        getData()
//                .buffer(5)
//                .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5,Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleepThred(60);
    }

    public static Flux<String> getData(){
        return Flux.interval(Duration.ofMillis(1000))
//                .take(3)
                .map(i->"item"+i);
    }
}
