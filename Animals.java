package edu.ucalgary.oop;
import java.util.*;

/**
 * @author Kenzy Hamed UCID:30140355
 * @version 1.5
 * @status 1.0
 *
 */

public class Animals {
    private static  LinkedList<Animal> animals= new LinkedList<Animal>();


    public Animals(HashMap<Integer,ArrayList<String>> original) {
        for (Integer entry : original.keySet()) {
            String nickname = original.get(entry).get(0);
            String type = original.get(entry).get(1);
            String species = DetermineSpecies(type);
            boolean orphan = isOrphan(entry);
            Animal animalInfo =new Animal(entry, nickname,type, species, orphan);
            animals.add(animalInfo);
        }

    }
    public static LinkedList<Animal> getAnimals(){
        return animals;

    }
    public String DetermineSpecies(String type){
        String spec="";
        for (AnimalTypes animal : AnimalTypes.values()) {
            if (animal.toString() == type){
                spec = animal.getType();
                break;
            }
        }

        return spec;

    }

    public boolean isOrphan( Integer Orphan){
        if (Treatments.getOrderedTreatments().containsKey(Orphan)){
            return true;
        }
        else{
            return false;
        }

    }












}