package com.reactiveProgramming.sec01Mono;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.onNext());
        Util.sleepThred(2);
    }
    public static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()->Util.faker().name().fullName());
    }
}
