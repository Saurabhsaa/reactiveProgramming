package com.reactiveProgramming.sec08CombiningPublishers;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {

        Flux.zip(getBody(),getEngine(),getTyres())
                .subscribe(Util.subscriber());

    }

    public static Flux<String> getBody(){
        return Flux.range(1,5)
                .map(i->"body");
    }

    public static Flux<String> getEngine(){
        return Flux.range(1,2)
                .map(i->"engine");
    }

    public static Flux<String> getTyres(){
        return Flux.range(1,6)
                .map(i->"tyres");
    }
}
