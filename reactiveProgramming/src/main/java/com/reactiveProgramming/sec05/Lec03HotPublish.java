package com.reactiveProgramming.sec05;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

    public static void main(String[] args) {
        //share = publish().refCount(1)
        Flux<String> stringFlux = Flux.fromStream(()->getMoveies())
                .delayElements(Duration.ofSeconds(2))
                .publish().refCount(2);

        stringFlux.subscribe(Util.subscriber("suman"));

        Util.sleepThred(5);

        stringFlux.subscribe(Util.subscriber("saurabh"));

        Util.sleepThred(30);
    }

    private static Stream<String> getMoveies(){
        System.out.println("Movie stream invoked");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }

}
