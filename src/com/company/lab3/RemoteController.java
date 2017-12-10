package com.company.lab3;

public class RemoteController {
    private TV tv;

    public void setTV(TV tv) {

        this.tv = tv;
    }

    public void toggle() {
        System.out.println("Trying to toggle tv from remote controller");
        if (tv == null) {
            System.out.println("There is no TV assigned to this remote controller");
        }
        else {
            tv.toggle();
        }
    }

    public void setChannel(Channel channel) {
        System.out.println("Trying to set channel from remote controller");
        if (tv == null) {
            System.out.println("There is no TV assigned to this remote controller");
        }
        else {
            tv.setChannel(channel);
        }
    }

    public void change(int number) {
        System.out.println("Trying to change channel from remote controller");
        if (tv == null) {
            System.out.println("There is no TV assigned to this remote controller");
        }
        else {
            tv.change(number);
        }
    }
}
