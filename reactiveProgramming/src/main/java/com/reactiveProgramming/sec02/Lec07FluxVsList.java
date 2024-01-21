package com.reactiveProgramming.sec02;

import com.reactiveProgramming.sec02.helper.NameGenerator;
import com.reactiveProgramming.utility.Util;

import java.util.List;


public class Lec07FluxVsList {

    public static void main(String[] args) {

        List<String> nameList = NameGenerator.getNames(5);
        //thread will be blocked for 5 sec and all data will be received at a time
        System.out.println(nameList);

        //will be continuously returning data and blockign will be for only 1 sec for each name
        NameGenerator.getNamesWithFlux(5)
                .subscribe(Util.onNext());

    }

}
