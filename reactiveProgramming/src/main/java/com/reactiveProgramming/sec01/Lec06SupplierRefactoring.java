package com.reactiveProgramming.sec01;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        //as Mono is a lazy initialization name will not be printed
        getName();

        //when will call subscribe method on getName then actual name will get printed
        getName().subscribe(Util.onNext());
    }

    public static Mono<String> getName(){
        System.out.println("Inside getName method");
        return Mono.fromSupplier(() -> {
            return Util.faker().name().firstName();
        }).map(String::toUpperCase);
    }

}
