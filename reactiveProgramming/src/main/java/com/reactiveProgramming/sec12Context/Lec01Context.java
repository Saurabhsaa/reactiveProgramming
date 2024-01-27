package com.reactiveProgramming.sec12Context;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Context {

    public static void main(String[] args) {
//        getWelcomeMessage().subscribe(Util.subscriber());
        getWelcomeMessage()
                .contextWrite(Context.of("user","saurabh"))
                .contextWrite(context -> context.put("user","suman"))
                .subscribe(Util.subscriber());
    }

    public static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user")){
                return Mono.just("Welcome "+contextView.get("user"));
            }else{
                return Mono.error(new RuntimeException("Unauthorized"));
            }
        });
    }

}
