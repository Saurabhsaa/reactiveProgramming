package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Delay {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.x","9"); // limit the buffer size

        Flux.range(0,100) //32 elements are request by default as we have delayElementCall in pipeline and it is using Queues class present in Reactor
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepThred(110);
    }

}
