package edu.ucalgary.oop;

import java.util.*;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.5
 * @since 1.0
 *
 * The Time class makes Node objects, then it puts them in a linked list when called which represent all hours of the day.
 *
 */


public class Time{
    private static Integer  hour = 0000;
    private static  LinkedList<Node> time= new LinkedList<Node>();

    public Time() {
        /**
         *This is the Time constructor that auto generates 23 node objects that represent all hours of the day. It
         * also sets the volunteer status to false, initializes the activity string list to 120 minutes per hour and the data with the correct hour number
         *It then adds all the node objects to a linked list called time that represents the whole day.
         */


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
        /**
         * Gets the time linked list made up of Node objects.
         * @return time, type is LinkedList<Node>
         */
        return time;
    }
}