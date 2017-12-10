package com.company.lab3;

import static com.company.lab3.TV.HZ.*;

public class Main {
    public static void main(String[] args) {
        TV sany = new TV();
        RemoteController sanyController = new RemoteController();
        sany.setRemoteController(sanyController);

        sanyController.toggle();

        sany.setChannel(new Channel("HOBOSTI", HZ4000));
        // no channel assigned to '1'
        sany.setChannel(new Channel("Ren-TV"));
        sany.setChannel(new Channel("4x4", HZ3000));
        sany.setChannel(new Channel("HTV", HZ1000));
        sany.setChannel(new Channel("First"));

        for (int i = 0; i < 7; i++) {
            sanyController.change(i);
        }

        System.out.println(sany.findChannel(HZ3000));
        System.out.println(sany.findChannel(HZ4000));
        System.out.println(sany.findChannel(HZ1488));


        sanyController.toggle();
    }
}
