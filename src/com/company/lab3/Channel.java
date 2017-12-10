package com.company.lab3;

public class Channel {
    private String name;
    private TV.HZ hz;

    public Channel(String name, TV.HZ hz) {
        this.name = name;
        this.hz = hz;
    }

    public Channel(String name) {
        this.name = name;
        this.hz = null;
    }

    public String getName() {
        return name;
    }

    public TV.HZ getHz() {
        return hz;
    }
}
