package com.reactiveProgramming.sec02FLux.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> nameList = new ArrayList<>();
        for(int i=0;i<count;i++){
            nameList.add(genearteName());
        }
        return nameList;
    }

    public static Flux<String> getNamesWithFlux(int count){
        return Flux.range(0,count)
                .map(i->genearteName());
    }


    public static String genearteName(){
        Util.sleepThred(1);
        return Util.faker().name().fullName();
    }

}
