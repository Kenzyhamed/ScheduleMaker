import java.util.ArrayList;
import java.util.HashMap;

public class Animals {

    private HashMap<Integer, String[]> animals= new HashMap<Integer, String[]>();




    public Animals(HashMap<Integer, String[]> original){
        for (Integer treatID : original.keySet()) {
            this.animals.put(treatID, original.get(treatID));


    }}

    public HashMap<Integer, String[]> getAnimals(){
        return animals;
    }





}
