package com.reactiveProgramming.sec02;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,3);
        Flux.fromIterable(li)
                .subscribe(Util.onNext());

        Integer[] integers = {4,5};
        Flux.fromArray(integers)
                .subscribe(Util.onNext());
    }

}
