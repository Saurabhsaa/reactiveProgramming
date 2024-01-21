package com.reactiveProgramming.utility;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    String name = "";

    DefaultSubscriber(String name){
        this.name = name;
    }

    DefaultSubscriber(){

    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name +" Received "+o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name +" ERROR "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name +" COMPLETED ");
    }
}
