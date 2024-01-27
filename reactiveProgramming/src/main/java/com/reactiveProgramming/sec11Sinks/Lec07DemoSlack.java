package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.sec11Sinks.assignment.SlackMember;
import com.reactiveProgramming.sec11Sinks.assignment.SlackRoom;
import com.reactiveProgramming.utility.Util;

public class Lec07DemoSlack {
    public static void main(String[] args) {
        SlackRoom slackRoom = new SlackRoom("reactor");
        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi All");

        Util.sleepThred(4);

        jake.says("Hey ");
        sam.says("I just wanted to say hi ..");

        Util.sleepThred(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys glad to be here ...");


        Util.sleepThred(60);


    }
}
