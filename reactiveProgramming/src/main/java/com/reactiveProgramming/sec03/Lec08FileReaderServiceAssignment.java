package com.reactiveProgramming.sec03;

import com.reactiveProgramming.sec03.assignment.FileReaderService;
import com.reactiveProgramming.utility.Util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec08FileReaderServiceAssignment {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/text01.txt");
        fileReaderService.read(path)
                .subscribe(Util.subscriber());
    }

}
