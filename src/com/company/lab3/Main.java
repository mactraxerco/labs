package com.company.lab3;

public class Main {
    public static void main(String[] args) {
        TV sany = new TV(5);
        RemoteController sanyController = new RemoteController();
        sany.setRemoteController(sanyController);

        sanyController.toggle();

        sany.setChannel(0, new Channel("HOBOSTI"));
        // no channel assigned to '1'
        sany.setChannel(2, new Channel("Ren-TV"));
        sany.setChannel(3, new Channel("4x4"));
        sany.setChannel(4, new Channel("HTV"));
        sany.setChannel(5, new Channel("First")); // Error

        for (int i = 0; i < 5; ++i) {
            sanyController.change(i);
        }

        sanyController.toggle();
    }
}
