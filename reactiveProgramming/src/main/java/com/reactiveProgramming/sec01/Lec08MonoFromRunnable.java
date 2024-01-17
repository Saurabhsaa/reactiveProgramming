package com.reactiveProgramming.sec01;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(sendMail()).subscribe(
                Util.onNext(),
                Util.onError(),
                ()->{
                    System.out.println("Received a call back after process completion");
                });

    }

    public static Runnable sendMail(){
        return () -> {
            Util.sleepThred(2);
            System.out.println("Sending email completed ");
        };
    }

}
