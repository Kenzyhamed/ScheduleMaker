

import java.util.HashMap;
import java.util.LinkedList;

public class Time {
    private int data;
    private boolean volunteer;
    private String[] activities;
    private Time next;

    public Time() {
        next = null;
        activities = new String[60];
        data = 0000;
        volunteer=false;

    }

    public Time(int d, Time n) {
        data = d;
        next = n;
    }

    public void setLinkNext(Time n) {
        next = n;
    }


    public Time getLinkNext() {
        return next;
    }


    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }

}
