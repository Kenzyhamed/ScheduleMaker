package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.3
 * @since 1.0
 *
 * The Treatment class makes treatment objects when called that contains all the information associated with a treatment
 * such as animalID, the TaskID, the treatment start hour, associated Animal information and associated task information.
 */

public class Treatment {

    private int TanimalID;
    private int TreatmentID;
    public int  TtaskID;
    public int startHour;

    public Animal animalAssociated;
    public Task taskAssociated;



    public Treatment(int anID, int  tasID, int strthr, int treatID) {
        /**
         *This is the Treatment constructor that creates a treatment object but first checks
         *if the there are any invalid inputs. It checks to see if the animal and task id is in order
         *compared to the already existing animal objects. It checks the start hour as well to see if it is between 0 and 24
         *If all is valid it creates the object and assigns all the inputs to the variables associated with the treatment object.
         *
         * @param anID the ID of the animal receiving the treatment
         * @param tasID the ID of the task associated with the treatment
         * @param strthr the start hour of the treatment
         */



            this.TanimalID = anID;
            this.TtaskID=tasID;
            this.startHour = (strthr * 100);
            this.TreatmentID=treatID;

            for(Animal animalNode:Animals.getAnimals()){
                if(anID==animalNode.getAnimalID()){
                    this.animalAssociated=animalNode;
                }
            }

            for(Task taskNode:Tasks.getTasks()){
                if(tasID==taskNode.getTaskID()){
                    this.taskAssociated=taskNode;
                }
            }




    }


    public int getStartHour(){
        /**
         * Gets the start hour that is associated with the treatment it was called from.
         * @return start hour that is associated with the  treatment it was called from, type is int
         */
        return startHour;
    }
    public int getTAnimalID(){
        /**
         * Gets the animal ID that is associated with the treatment it was called from.
         * @return animal ID that is associated with the  treatment it was called from, type is int
         */
        return TanimalID;
    }
    public int getTreatmentID(){
        /**
         * Gets the treatment ID that is associated with the treatment it was called from.
         * @return treatment ID that is associated with the  treatment it was called from, type is int
         */
        return TreatmentID;
    }
    public Animal getAnimalassociated(){
        /**
         * Gets the animal object that is associated with the treatment it was called from.
         * @return animal object  that is associated with the  treatment it was called from, type is object-Animal
         */
        return animalAssociated;
    }
    public Task getTaskAssociated(){
        /**
         * Gets the task object that is associated with the treatment it was called from.
         * @return task object  that is associated with the  treatment it was called from, type is object-Task
         */
        return taskAssociated;
    }
    public void setStartHour(int strthr){
        /**
         * Sets the start hour of the treatment it was called from to the new start hour that was passed into the method.
         * @param strthr start hour of that is associated with the  treatment it was called from - type  is int
         */
        this.startHour=strthr;
    }

}
