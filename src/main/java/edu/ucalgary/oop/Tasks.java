package edu.ucalgary.oop;
import java.util.*;

/**
 * @author Kenzy Hamed UCID:30140355
 * @version 1.8
 * @status 1.0
 *
 */

public class Tasks {
    private static LinkedList<Task> tasks= new LinkedList<Task>();
    private  static LinkedHashMap<Integer, ArrayList<String>> orderedTasks= new LinkedHashMap<Integer, ArrayList<String>>();
    private ArrayList<Integer> orderedMaxWindows = new ArrayList<>();




    //Constructor//
    public Tasks(LinkedHashMap<Integer, ArrayList<String>> original){
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
        return tasks;
    }
    public ArrayList<Integer> listOfMaxWindows (){return orderedMaxWindows;}
    public static LinkedHashMap<Integer, ArrayList<String>> getOrderedTasks(){
        return orderedTasks;
    }













}
