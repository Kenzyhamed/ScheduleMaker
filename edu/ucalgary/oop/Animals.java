package edu.ucalgary.oop;
import java.util.*;


public class Animals {

    private LinkedHashMap<Integer, String[]> animals= new LinkedHashMap<Integer, String[]>();




    public Animals(HashMap<Integer, String[]> original){
        for (Integer treatID : original.keySet()) {
            this.animals.put(treatID, original.get(treatID));


    }}

    public HashMap<Integer, String[]> getAnimals(){
        return animals;
    }





}
