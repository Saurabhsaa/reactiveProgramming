package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.sec09Batching.helper.BookOrder;
import com.reactiveProgramming.sec09Batching.helper.RevenueReport;
import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {

    public static void main(String[] args) {
        Set<String> allowedFeatures = Set.of("Science fiction","Fantacy","Suspense/Thriller");

        bookStream()
                .filter(i->allowedFeatures.contains(i.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalculator(list))
                .subscribe(Util.subscriber());

        Util.sleepThred(60);

    }

    private static RevenueReport revenueCalculator(List<BookOrder> bookOrderList){
        Map<String,Double> map = bookOrderList.stream().collect(
                Collectors.groupingBy(BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i->new BookOrder());
    }

}
