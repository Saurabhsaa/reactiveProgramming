package com.reactiveProgramming.sec03.assignment;

import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    private Callable<BufferedReader> openReader(Path path){
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>,BufferedReader> read(){
        return (br,sink) -> {
            try {
                String line = br.readLine();
                if(ObjectUtils.isEmpty(line)){
                    sink.complete();
                }else {
                    sink.next(line);
                }
            }catch (Exception e){
                sink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader(){
        return (br)->{
           try {
               br.close();
           } catch (Exception e){
               e.printStackTrace();
           }
        };
    }

    public Flux<String> read(Path path){
        return Flux.generate(openReader(path),
                read(),
                closeReader());
    }

}
