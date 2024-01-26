package com.reactiveProgramming.sec05;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublishAutoConnect {

    public static void main(String[] args) {
         Flux<String> stringFlux = Flux.fromStream(()->getMoveies())
                 .delayElements(Duration.ofSeconds(1))
                 .publish()
                 .autoConnect(0);

         Util.sleepThred(3);

         stringFlux.subscribe(Util.subscriber("mike"));

         Util.sleepThred(7);

         System.out.println("Invoking second stream");

         stringFlux.subscribe(Util.subscriber("sam"));

         Util.sleepThred(60);

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
