package com.reactiveProgramming.sec02FLux;

import com.reactiveProgramming.sec02FLux.assignment.PricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;

public class Lec11AssignmentPriceTracker {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        PricePublisher.getStockPrice().subscribeWith(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println("Date time : "+ LocalDate.now() + "Price : "+price);
                if (price >= 110 || price <= 90) {
                    System.out.println("Circuit Hitted ...");
                    subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("Error due to "+throwable.getMessage());
                subscription.cancel();
                latch.countDown();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed ..");
                latch.countDown();
            }
        });
        latch.await();
    }

}
