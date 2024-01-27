package com.reactiveProgramming.sec08CombiningPublishers;

import com.reactiveProgramming.sec08CombiningPublishers.helper.AirIndiaFlights;
import com.reactiveProgramming.sec08CombiningPublishers.helper.EmiratesFlights;
import com.reactiveProgramming.sec08CombiningPublishers.helper.QatarFlights;
import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {
        Flux<String> flightsDetailsFlux = Flux.merge(AirIndiaFlights.getFlights(),
                QatarFlights.getFlights(), EmiratesFlights.getFlights());

        flightsDetailsFlux.subscribe(Util.subscriber());

        Util.sleepThred(10);
    }
}
