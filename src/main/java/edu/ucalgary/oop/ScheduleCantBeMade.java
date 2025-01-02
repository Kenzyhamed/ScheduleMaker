package edu.ucalgary.oop;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.3
 * @since 1.0
 *
 * The ScheduleCantBeMade class that takes care of the program when a medical task cant be fit into the schedule
 */


public class ScheduleCantBeMade {

    public ScheduleCantBeMade(int treatID, String newStartHr){
        /**
         *This is the ScheduleCantBeMade constructor that references the updateTask method in Loader, it passes in the treatment id of the
         * treatment that cant be put in the schedule and the new start hour that the user has suggested.After updating the database it will creat a new instance of the main class and run it again
         * with the new databse
         *
         * @param treatID treatment ID
         * @param newStartHr starthour input by user
         */
        Loader.updateTask(treatID, newStartHr);
        Loader newSchedule = new Loader();

}}
