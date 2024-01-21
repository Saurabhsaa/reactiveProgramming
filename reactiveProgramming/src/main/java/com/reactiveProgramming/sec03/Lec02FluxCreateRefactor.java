package com.reactiveProgramming.sec03;

import com.reactiveProgramming.sec03.helper.NameProducer;
import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());
//        nameProducer.producer();

        Runnable runnable = () -> nameProducer.producer();
        for (int i=0;i<10;i++){
            if(i==5){
                Util.sleepThred(10);
            }
            new Thread(runnable).start();
        }

    }

}
