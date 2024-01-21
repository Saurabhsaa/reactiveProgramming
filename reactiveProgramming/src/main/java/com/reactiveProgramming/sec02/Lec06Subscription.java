package com.reactiveProgramming.sec02;

import com.reactiveProgramming.utility.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();

        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Printing subscription object "+subscription);
                        subscriptionAtomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("received "+integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("ERROR : "+throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });

        Subscription subscription = subscriptionAtomicReference.get();
        subscription.request(2);
        Util.sleepThred(3);
        subscription.request(2);
        Util.sleepThred(3);
        subscription.cancel();
        subscription.request(5); //once the subscription is canceled data can not be requested again
        Util.sleepThred(3);
    }

}
