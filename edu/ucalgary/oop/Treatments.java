package edu.ucalgary.oop;
import java.util.*;
/**
 * Treatments: This class takes the treatments linked hash map  ------
 * @author Kenzy Hamed UCID:30140355
 * @version 1.9
 * @since  1.0
 *
 */
public class Treatments{
    /*
    orders all treatments based on less flexible -MaxWindow
     */


    private static  LinkedList<Treatment> treatments= new LinkedList<Treatment>();
    private static LinkedHashMap<Integer, ArrayList<String>> orderedTreatments= new LinkedHashMap<Integer, ArrayList<String>>();




    //Constructors//

    public Treatments( LinkedHashMap<Integer, ArrayList<String>> original){
        orderTreatments(original);
        for (Integer entry : orderedTreatments.keySet()) {
            int taskid= Integer.parseInt(orderedTreatments.get(entry).get(1));
            int startHour = Integer.parseInt(orderedTreatments.get(entry).get(2));
            int animalid = Integer.parseInt(orderedTreatments.get(entry).get(0));
            Treatment treatmentInfo =new Treatment(animalid, taskid,startHour);
            treatments.add(treatmentInfo);}
}
    //Getters//
    public static LinkedHashMap<Integer, ArrayList<String>> getOrderedTreatments(){return orderedTreatments;}

    public static LinkedList<Treatment> getTreatments(){
        return treatments;
    }


    public void  orderTreatments(LinkedHashMap<Integer, ArrayList<String>> origin){

        for (Integer id : Tasks.getOrderedTasks().keySet()){
            for(Integer key : origin.keySet()){
                if(Integer.parseInt(origin.get(key).get(1)) == id){
                    orderedTreatments.put(key,origin.get(key));

                }
            }
        }


    }



}

