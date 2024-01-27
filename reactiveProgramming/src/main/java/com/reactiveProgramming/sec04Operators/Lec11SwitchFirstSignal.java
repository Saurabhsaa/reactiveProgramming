package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.sec04Operators.helper.Person;
import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec11SwitchFirstSignal {

    public static void main(String[] args) {
        getPersons()
                .switchOnFirst((signal,personFlux) -> {
                        return (signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux));
                })
                .subscribe(Util.subscriber());
    }

    private static Flux<Person> getPersons(){
        return Flux.range(0,10)
                .map(i -> new Person());
    }

    private static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return fluxPerson -> fluxPerson.filter(person -> person.getAge()>10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class,person -> System.out.println("Disgarded "+person));
    }
}
