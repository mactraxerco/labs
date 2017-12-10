package com.company.lab3;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TV {
    public enum HZ {
        HZ1000,
        HZ2000,
        HZ3000,
        HZ4000,
        HZ5000,
        HZ1488,
        HZ1597
    }

    private HZ hz;
    private boolean enabled;
    private List<Channel> channels;
    private RemoteController remoteController;
    private Map<HZ, Integer> herzToNumber;


    public TV() {
        herzToNumber = new HashMap<>();
        herzToNumber.put(HZ.HZ1000, 0);
        herzToNumber.put(HZ.HZ2000, 1);
        herzToNumber.put(HZ.HZ3000, 2);
        herzToNumber.put(HZ.HZ4000, 3);
        herzToNumber.put(HZ.HZ5000, 4);
        herzToNumber.put(HZ.HZ1488, 5);
        herzToNumber.put(HZ.HZ1597, 6);

        channels = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
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


    public void setChannel(Channel channel) {
        if (!this.enabled) {
            System.out.println("TV is disabled");
            return;
        }

        try {
            int channelNumber = -1;
            if (channel.getHz() != null) {
                channelNumber = herzToNumber.get(channel.getHz());
            }
            else {
                for (Map.Entry<HZ, Integer> entry : herzToNumber.entrySet())
                {
                    if (channels.get(entry.getValue()) == null) {
                        channelNumber = entry.getValue();
                        break;
                    }
                }

                if (channelNumber == -1) {
                    throw new IndexOutOfBoundsException();
                }
            }

            channels.set(channelNumber, channel);

            System.out.println(channel.getName() + " is now at '" + channelNumber + "'");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Unable to set channel");
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

    public String findChannel(HZ hz) {
        for (int i = 0; i < channels.size(); i++) {
            if (channels.get(i) != null && channels.get(i).getHz() == hz)
                return "This is " + channels.get(i).getName() + " channel";
        }
        return "Сhannel is not found";
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
        remoteController.setTV(this);
    }
}
