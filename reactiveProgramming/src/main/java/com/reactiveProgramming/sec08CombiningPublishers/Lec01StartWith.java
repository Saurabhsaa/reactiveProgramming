package com.reactiveProgramming.sec08CombiningPublishers;

import com.reactiveProgramming.sec08CombiningPublishers.helper.NameGenerator;
import com.reactiveProgramming.utility.Util;

public class Lec01StartWith {

    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();

        nameGenerator.generateName()
                .take(2)
                .subscribe(Util.subscriber("suman"));

        nameGenerator.generateName()
                .take(2)
                .subscribe(Util.subscriber("stalin"));

        nameGenerator.generateName()
                .take(3)
                .subscribe(Util.subscriber("saurabh"));

        nameGenerator.generateName()
                .filter(name -> name.startsWith("S"))
                .take(2)
                .subscribe(Util.subscriber("ajey"));

    }

}
