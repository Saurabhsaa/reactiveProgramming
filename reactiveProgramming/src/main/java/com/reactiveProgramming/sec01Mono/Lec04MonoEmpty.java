package com.reactiveProgramming.sec01Mono;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmpty {

    public static void main(String[] args) {

        userRepository(1).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        userRepository(2).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        userRepository(16).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }

    public static Mono<String> userRepository(int userId){
        if(userId==1){
            return Mono.just(Util.faker().name().firstName());
        } else if (userId==2) {
            return Mono.empty(); //return null
        }else {
            return Mono.error(new RuntimeException("ERROR : Not in allowed Range"));
        }
    }

}
