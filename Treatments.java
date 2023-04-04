import java.util.*;

public class Treatments{
    /*
    orders all treatments based on less flexible -MaxWindow
     */

    private static LinkedHashMap<Integer, ArrayList<String>> treatments= new LinkedHashMap<Integer, ArrayList<String>>();
    private static LinkedHashMap<Integer, ArrayList<String>> orderedTreatments= new LinkedHashMap<Integer, ArrayList<String>>();
    private static Collection<Integer> listOfTaskID;





    public Treatments( LinkedHashMap<Integer, ArrayList<String>> original){

        for (Integer treatID : original.keySet()) {
            treatments.put(treatID, original.get(treatID));

    }}

    public static HashMap<Integer, ArrayList<String>> getOrderedTreatments(){
        return orderedTreatments;
    }



    public static void  orderTreatments(LinkedHashMap<Integer, ArrayList<String>> orderedTasks){
        /* Orders based on Task ID of TaskID of orderedTasks */
        listOfTaskID = orderedTasks.keySet();//keys of original linkedhashmap
        //ordering the maxWindow values from lowest to highest
        for (Integer id : listOfTaskID){//iterating through listOfTaskID
            for(Integer key : treatments.keySet()){ // iterating through keys of the original and seeing if the last value of the Values that belongs to the key is the same as max value
                if(key == id){
                    orderedTreatments.put(key,treatments.get(key));//if yes it will ad that key and value into ordered tasks
                }
            }
        }


    }





    


}
