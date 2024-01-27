package com.reactiveProgramming.sec06ThreadingAndSchedulars;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {

        //interval method internally uses parallel()  and so main thread is not getting blocked here
        // if we are not blocking main thread manually even interval() emits unlimited data we can not consume it .
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

//        Util.sleepThred(5);
    }
}
