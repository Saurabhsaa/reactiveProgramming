package com.reactiveProgramming.sec03.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> stringFluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.stringFluxSink = stringFluxSink;
    }

    public void producer(){
        String name = Util.faker().name().fullName();
        Util.sleepThred(2);
        this.stringFluxSink.next(Thread.currentThread().getName() +" : "+ name);
    }
}
