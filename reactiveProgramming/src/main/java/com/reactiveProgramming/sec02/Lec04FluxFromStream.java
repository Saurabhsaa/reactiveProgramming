package com.reactiveProgramming.sec02;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);
        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println); //closed
//        stream.forEach(System.out::println);
        Flux<Integer> fluxStream = Flux.fromStream(stream);
        fluxStream.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fluxStream.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());


        Flux<Integer> fluxStreams = Flux.fromStream(()->list.stream());

        fluxStreams.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fluxStreams.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

    }

}
