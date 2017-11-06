package com.company.lab3;

import java.util.ArrayList;
import java.util.List;

public class TV {
    private boolean enabled;
    private List<Channel> channels;
    private RemoteController remoteController;

    public TV(int maxChannelCount) {
        channels = new ArrayList<>(maxChannelCount);
        for (int i = 0; i < maxChannelCount; ++i) {
            channels.add(null);
        }
        enabled = false;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) {
            System.out.println("TV is now enabled");
        }
        else {
            System.out.println("TV is now disabled");
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setChannel(int channelNumber, Channel channel) {
        if (!this.enabled) {
            System.out.println("TV is disabled");
            return;
        }

        try {
            channels.set(channelNumber, channel);
            System.out.println(channel.getName() + " is now at '" + channelNumber + "'");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Unable to set channel at '" + channelNumber + "'");
        }
    }

    public void change(int number) {
        if (!this.enabled) {
            System.out.println("TV is disabled");
            return;
        }

        try {
            Channel channel = channels.get(number);
            System.out.println("Switched to '" + number + "'");
            if (channel == null) {
                System.out.println("There is no channel assigned");
            }
            else {
                System.out.println("There is a channel with name '" + channel.getName() + "'");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to open channel '" + number + "'");
        }
        System.out.println();
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
        remoteController.setTV(this);
    }
}
