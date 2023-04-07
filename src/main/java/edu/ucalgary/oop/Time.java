package edu.ucalgary.oop;

import java.util.*;

public class Time{
    private static Integer  hour = 0000;
    private static  LinkedList<Node> time= new LinkedList<Node>();

    public Time() {


        // Initialize 24 nodes with random data
        for (int i = 0; i < 24; i++) {

            boolean volunteer = false;
            String[] activities = new String[120];
            int data = hour;
            hour=hour+100;
            Node hours =new Node(volunteer, activities,data);
            time.add(hours);
        }
    }

    public static LinkedList<Node> getTime(){
        return time;
    }
}