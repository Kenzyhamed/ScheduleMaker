/**
 * @author Kenzy Hamed 30140355
 * @version 1.6
 * @since 1.0
 *
 * The Animal class makes animal objects when called that contains all the information associated with an animal
 * such as if it's an orphan or not, its id, its name, the type of animal and its behavioural species.
 *
 */
package edu.ucalgary.oop;
import java.util.ArrayList;



public class Animal {

    private  int animalID;

    public  String  animalNickname;

    public  String animalType;

    public  String animalSpecies;

    public boolean orphan;


    public Animal(int iD, String  nickname, String type, String species) throws IllegalArgumentException {
        /**
         * This is the Animal constructor that creates an Animal object but first checks
         * if the there are any invalid inputs. It checks to see if the id is in order
         * compared to the already existing animal objects. It checks the type and species according to valid type/species
         * in the AnimalTypes enum, which contains all the acceptable animal types and animal species.
         * If all is valid it creates the object and assigns all the inputs to the variables associated with the animal object.
         * It calls getOrphan which checks to see if the animal is an orphan.
         *
         * @param iD id of the animal, type is integer
         * @param nickname name of animal, type is string
         * @param type type of the animal, type is string
         * @param species the behavioural species of the animal, type id string
         * @throws IllegalArgumentException if id, species, and type is invalid it throws the error and doesn't create the animal object
         *
         */




            this.animalID = iD;
            this.animalNickname = nickname;
            this.animalType = type;
            this.animalSpecies =species;
            getOrphan();




    }

    public int getAnimalID(){
        /**
         * Gets the animals id that is associated with the object it was called from.
         * @return animalID that is associated with the object it was called from, type is int
         */
        return animalID;
    }
    public String getAnimalNickname(){
        /**
         * Gets the animals name that is associated with the object it was called from.
         * @return animalNickname that is associated with the object it was called from, type is String
         */
        return animalNickname;
    }
    public String getAnimalSpecies(){
            /**
             * Gets the animals behavioral species that is associated with the object it was called from.
             * @return animalSpecies that is associated with the object it was called from, type is String
             */
        return animalSpecies;
    }
    public String getAnimalType(){
        /**
         * Gets the animals type species that is associated with the object it was called from.
         * @return animalType that is associated with the object it was called from, type is String
         */
        return animalType;
    }
    public boolean getOrphan(){
        /**
         * Checks if the animal that is  being created is an orphan or not, by iterating through the keys of the ordered treatments
         * and if the animal ID associates with the treatment is the same as the animal id of the animal being created then
         * it will check if associated task is 1, if true then the animal is an orphan.
         * @return orphan that is true is animal is found to be an orphan or false if it is not, type is boolean
         */

        for(Integer treatID : Treatments.getOrderedTreatments().keySet()){
            if(Integer.parseInt(Treatments.getOrderedTreatments().get(treatID).get(0))==this.animalID){
                this.orphan= Treatments.getOrderedTreatments().get(treatID).get(1).equals("1");
            }
        }
        return orphan;
    }




}
