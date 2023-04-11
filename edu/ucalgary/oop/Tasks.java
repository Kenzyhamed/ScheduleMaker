package edu.ucalgary.oop;
import java.util.*;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.11
 * @since 1.0
 *
 * The Tasks class prepares the treatments that are to be scheduled one by one. It inherits the methods provided by ScheduleMaker since it extends it.
 *
 */

public class Tasks {
    private static LinkedList<Task> tasks= new LinkedList<Task>();
    private  static LinkedHashMap<Integer, ArrayList<String>> orderedTasks= new LinkedHashMap<Integer, ArrayList<String>>();
    private ArrayList<Integer> orderedMaxWindows = new ArrayList<>();




    //Constructor//
    public Tasks(LinkedHashMap<Integer, ArrayList<String>> original){
        /**
         *orders the original linked hashmpa based on theirs maxwindow then takes each entry of the linked hashmap and makes a new task object and adds it to the
         * linked list tasks
         * @param original original sql Tasks table in the form of a HashMap
         */

        for (ArrayList<String> value : original.values()) {
            orderedMaxWindows.add(Integer.parseInt(value.get(2)));}
        Collections.sort(orderedMaxWindows);
        for (Integer max : orderedMaxWindows){
            for(Integer key : original.keySet()){
                if(Integer.parseInt(original.get(key).get(2)) == max){
                    orderedTasks.put(key,original.get(key));
                }
            }
        }


        for(Integer tskID: orderedTasks.keySet()){
            int id=tskID;
            String desc = orderedTasks.get(tskID).get(0);
            int durat = Integer.parseInt(orderedTasks.get(tskID).get(1));
            int mxWin = Integer.parseInt(orderedTasks.get(tskID).get(2));
            Task newtask=new Task(tskID, desc, durat, mxWin);
            tasks.add(newtask);
        }

    }






    //Getters//
    public static LinkedList<Task> getTasks(){
        /**
         * Gets a linked list of all the tasks that contains task objects
         * @return tasks, type is LinkedList<Task>
         */

        return tasks;
    }
    public ArrayList<Integer> listOfMaxWindows (){
        /**
         * Gets an array list of all the maximum windows ordered in ascending order
         * @return orderedMaxWindows, type is ArrayList<Integer>
         */

        return orderedMaxWindows;
    }
    public static LinkedHashMap<Integer, ArrayList<String>> getOrderedTasks(){
        /**
         * Gets the ordered tasks in Linked hash map form-they should be ordered based on their max window in ascending order
         * @return orderedTasks, type is LinkedHashMap<Integer, ArrayList<String>>
         */

        return orderedTasks;
    }













}
