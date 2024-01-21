package com.reactiveProgramming.sec03;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink->{
            String country ;
            do{
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while(!country.toLowerCase().equals("india"));
        }).subscribe(Util.subscriber());
    }

}
