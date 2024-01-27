package com.reactiveProgramming.sec11Sinks.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {

    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name){
        this.name = name;
        sink = Sinks.many().replay().all();
        flux = sink.asFlux();
    }

    public void joinRoom(SlackMember slackMember){
        System.out.println(slackMember.getName() +"--- joined --- "+this.name);
        this.subscribe(slackMember);
        slackMember.setMessageConsumer(msg -> {
            this.postMessage(msg,slackMember);
        });
    }

    public void subscribe(SlackMember slackMember){
        this.flux.doOnNext(sm -> sm.setReceiver(slackMember.getName()))
                .map(slackMessage -> slackMessage.toString())
                .subscribe((mess)->slackMember.receiveMessage(mess));
    }

    private void postMessage(String msg,SlackMember slackMember){
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setMessage(msg);
        slackMessage.setSender(slackMember.getName());
        this.sink.tryEmitNext(slackMessage);
    }

}
