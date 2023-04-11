package edu.ucalgary.oop;
import java.util.*;

/**
 * The Animals class makes animal objects for each animal in the sql database and putting it into an animals linked list that contains
 * all the animal object
 *
 * @author Kenzy Hamed UCID:30140355
 * @version 1.5
 * @status 1.0
 *
 */

public class Animals {
    private static final LinkedList<Animal> animals= new LinkedList<Animal>();


    public Animals(HashMap<Integer,ArrayList<String>> original) {
        /**
         * Creates an instance of Animals by iterating over a HashMap of animal information and creating
         * a list of Animal objects for each entry of the Hashmap, with the key/Integer being the animal ID, the first index of the
         * Arraylist being the name of the animal, the second being the type, then using the DetermineSpecies method to find the species associated with the
         * type of the animal. Then adds the object created into an animals linked list.
         *
         * @param original a HashMap<Integer,ArrayList<String>> containing information about all the animals in the SQL Animals table
         */
        for (Integer entry : original.keySet()) {
            String nickname = original.get(entry).get(0);
            String type = original.get(entry).get(1);
            String species = DetermineSpecies(type);

            Animal animalInfo =new Animal(entry, nickname,type, species);
            animals.add(animalInfo);
        }

    }
    public static LinkedList<Animal> getAnimals(){
        /**
         * Gets the animals linked list.
         * @return animals that is associated with the object it was called from, type is LinkedList<Animal>
         */
        return animals;
    }
    public String DetermineSpecies(String type){
        /**
         * Determines the animals species by using the parameter, which is the type of animal, to iterate through
         * the Animal types enumeration to find the animal that matches with the type that is passed into the method.
         * Then it will use that animal to access its species and assign it  to the spec variable and return it
         *
         *
         * @return spec animals determined species, type is String
         * @param type  type of animal
         */
        String spec="";
        for (AnimalTypes animal : AnimalTypes.values()) {
            if (animal.toString() == type){
                spec = animal.getType();
                break;
            }
        }
        return spec;
    }

}