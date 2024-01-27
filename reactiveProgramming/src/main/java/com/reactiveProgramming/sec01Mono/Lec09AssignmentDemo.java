package com.reactiveProgramming.sec01Mono;

import com.reactiveProgramming.sec01Mono.assignment.FileService;
import com.reactiveProgramming.utility.Util;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {
        FileService.read("text1.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        FileService.write("text3.txt","This is new file 3")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        ()-> System.out.println("New file created ."));

        FileService.delete("text2.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        ()-> System.out.println("File deleted successfully"));

    }

}
