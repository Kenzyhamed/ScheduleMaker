package edu.ucalgary.oop;
/**
 * @author Kenzy Hamed 30140355
 * @version 1.11
 * @since 1.0
 *
 * The ScheduleTasks class prepares the treatments that are to be scheduled one by one. It inherits the methods provided by ScheduleMaker since it extends it.
 */

public  class ScheduleTasks extends ScheduleMaker{


    public ScheduleTasks() {
        /**
         *This is the ScheduleTasks constructor that iterates through the treatment linked list and obtains all the info/variables
         * about the treatment and calls the schedule tasks method in schedule maker to put the medical tasks in the schedule.
         *
         */
        for(Treatment entry: Treatments.getTreatments()){
            Task task=entry.getTaskAssociated();
            Animal animal =entry.getAnimalassociated();
            scheduleTasks(entry.getStartHour(), task.getDuration(), task.getMaxWin(), animal.getAnimalNickname(), task.getDescription(), entry.getTreatmentID());

            }}

}
