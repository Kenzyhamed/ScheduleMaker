package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.13
 * @since 1.0
 *
 * The Schedule maker is the parent class for the rest of the classes,it initializes and creates objects for  all the other classes and has
 */

public class ScheduleMaker {
    private Treatments treatments;
    private Tasks tasks;
    private Animals animals;
    private Time hoursInDay;
    private ScheduleFeeding feeding;

    int amount;

    public ScheduleMaker() {}

    public ScheduleMaker(LinkedHashMap<Integer, ArrayList<String>> treat, LinkedHashMap<Integer, ArrayList<String>> task, LinkedHashMap<Integer, ArrayList<String>> animal) {

        hoursInDay = new Time();
        animals = new Animals(animal);
        tasks = new Tasks(task);
        treatments = new Treatments(treat);
    }


    public void scheduleTasks(int strthr, int durat, int mxW, String name, String desc, int treatID) {
        int startHr = strthr;
        int maxWin = mxW;
        int duration = durat;
        String description = desc;
        String animalName = name;
        for (Node node : Time.getTime()) {
            if (startHr == node.getData()) {
                if (containsNull(node.getActivities()) && amount >= duration) {
                    String filling = description + " (" + animalName + ")";
                    fill(node, duration, filling);

                }else if (maxWin > 1 ) {
                    startHr += 100;
                    maxWin = -1;}
                else {
                    GUIForError start = new GUIForError(description,name,String.valueOf(strthr)); //these are all strings
                    int newStarthour;
                    while(!start.getStates()){
                        System.out.println(true);
                    }
                    newStarthour=start.getSelectedHour();
                    ScheduleCantBeMade error = new ScheduleCantBeMade(treatID,String.valueOf(newStarthour));

                }
            }
        }


    }







    public boolean containsNull(String[] values) {
        /**
         * Contains null is a method that iterates over the activuties string list and checks if tehre are null spaces
         * if there is it return  true if not it returns false, it also updates a local variable called amount that contains the amount of spaces that are availabl in the specifc activity.
         * @param values, activity String list type is String[]
         * @returns space, type boolean
         */

        boolean space = false;
        amount = 0;
        for (String o : values) {
            if (o == null) {
                space = true;
                amount += 1;
            }
        }
        return space;
    }


    public void ScheduleVolunteer() {

        for (Node node : Time.getTime()) {
            int count = 0;
            for (int i = 0; i < node.activities.length; i++) {
                if (node.activities[i] != null) {
                    count += 1;
                }
            }
            if (count > 60) {
                node.setVolunteer(true);
                node.getData();
                VolGUI start = new VolGUI(Integer.toString(node.getData()));
                while(!start.getState()){
                    //program wont continue until the user presses confirm

                }
            }
        }
    }
    public void fill(Node node, int duration, String filling){
        /**
         * fill is a method that fills the activity list with a specic filling string, it searched to find when the actibvity list has an empty space and  checks to see if the uration
         * is zero before filling in the activity, and subtracting one from the duration for every time it does this
         * @param node, the current node it is at type is Node object
         * @param duration the duration of the duty, type is int
         * @param filling the filling item that should fill the activity list, type String
         */
        for (int i = 0; i < node.activities.length; i++) {
            if (node.activities[i] == null && (duration != 0)) {
                node.activities[i] = filling;
                duration -= 1;
            }
        }
    }




}
