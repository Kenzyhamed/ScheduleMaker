package edu.ucalgary.oop;
import java.util.*;
/**
 *
 * @author Kenzy Hamed UCID:30140355
 * @version 1.9
 * @since  1.0
 * The Treatments class makes treatment objects for each treatment in the sql database, orders the treatments based on their task id(which was previously ordered by Max Window,
 * then puts the ordered treatments it into a treatments linked list that contains
 *  all the treatment objects
 *
 */
public class Treatments{
    /*
    orders all treatments based on less flexible -MaxWindow
     */

    //Variables//
    private static  LinkedList<Treatment> treatments= new LinkedList<Treatment>();
    private static LinkedHashMap<Integer, ArrayList<String>> orderedTreatments= new LinkedHashMap<Integer, ArrayList<String>>();




    //Constructors//

    public Treatments( LinkedHashMap<Integer, ArrayList<String>> original){


        orderTreatments(original);
        for (Integer entry : orderedTreatments.keySet()) {
            int taskid= Integer.parseInt(orderedTreatments.get(entry).get(1));
            int startHour = Integer.parseInt(orderedTreatments.get(entry).get(2));
            int animalid = Integer.parseInt(orderedTreatments.get(entry).get(0));
            Treatment treatmentInfo =new Treatment(animalid, taskid,startHour, entry);
            treatments.add(treatmentInfo);}
}
    //Getters//
    public static LinkedHashMap<Integer, ArrayList<String>> getOrderedTreatments(){
        /**
         * Gets the ordered treatments linked Hashmap, which should be ordered based on their task id, which was ordered based on max Window
         * @return orderedTreatments, type is LinkedHashMap<Integer, ArrayList<String>>
         */
        return orderedTreatments;
    }

    public static LinkedList<Treatment> getTreatments(){
        /**
         * Gets the treatments linked list, which should be ordered based on their task id, which was ordered based on max Window
         * @return treatments that is associated with the object it was called from, type is LinkedList<Animal>
         */

        return treatments;
    }

     //Methods//
    public void  orderTreatments(LinkedHashMap<Integer, ArrayList<String>> origin){
        /**
         * Orders the treatments linked Hashmap, which should be ordered based on their task id, which was ordered based on max Window.
         * It does this by iterating through the keys of the ordered tasks and iterates through the original unchanged treatments hashmap keyset.
         * if the id of the task equals the second index of the value of the treatment key  then the method will put
         * the treatment key and its array list values into the ordered treatment linked Hash Map.
         *
         * @param origin original Linked Hashmap that is created from the SQL database , type is LinkedHashMap<Integer, ArrayList<String>>
         */
        for (Integer id : Tasks.getOrderedTasks().keySet()){
            for(Integer key : origin.keySet()){
                if(Integer.parseInt(origin.get(key).get(1)) == id){
                    orderedTreatments.put(key,origin.get(key));
                }
            }
        }
    }



}

