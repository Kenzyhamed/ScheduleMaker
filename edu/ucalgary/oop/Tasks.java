package edu.ucalgary.oop;
import java.util.*;

public class Tasks {
    private LinkedHashMap<Integer, ArrayList<String>> tasks= new LinkedHashMap<Integer, ArrayList<String>>();
    private LinkedHashMap<Integer, ArrayList<String>> orderedTasks= new LinkedHashMap<Integer, ArrayList<String>>();
    private ArrayList<Integer> listOfMaxWindows = new ArrayList<>();





    public Tasks(LinkedHashMap<Integer, ArrayList<String>> original){
        for (Integer treatID : original.keySet()) {
            this.tasks.put(treatID, original.get(treatID));

        }
        orderTasks();
    }

    public LinkedHashMap<Integer, ArrayList<String>> getTasks(){
        return tasks;
    }
    public LinkedHashMap<Integer, ArrayList<String>> getOrderedTasks(){
        return orderedTasks;
    }


    public void orderTasks(){
        /*orders linkedhashmap based on maxWindow*/
        Collection<ArrayList<String>> values = tasks.values();//values of original linkedhashmap


        for (ArrayList<String> value : values) {
            listOfMaxWindows.add(Integer.parseInt(value.get(3)));//iterating through values to get maxWindow values
        }
        Collections.sort(listOfMaxWindows);
        //ordering the maxWindow values from lowest to highest
        for (Integer max : listOfMaxWindows){//iterating through listofMaxvalues from least max to most max
            for(Integer key : tasks.keySet()){ // iterating through keys of the original and seeing if the last value of the Values that belongs to the key is the same as max value
                if(Integer.parseInt(tasks.get(key).get(3)) == max){
                    orderedTasks.put(key,tasks.get(key));//if yes it will ad that key and value into ordered tasks
                }
            }
        }
        Treatments.orderTreatments(orderedTasks);
}






}
