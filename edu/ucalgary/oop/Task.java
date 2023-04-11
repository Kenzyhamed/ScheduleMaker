package edu.ucalgary.oop;

public class Task {
    /**
     * @author Kenzy Hamed 30140355
     * @version 1.11
     * @since 1.0
     *
     * The Tasks class that creates Task objects when called that contains all the information associated with a task
     *  * such as its id, the description, the max window, and the duration it takes.
     */


    private int taskID;
    public String  description;
    public int duration;
    public int maxWin;


    public Task(int ID, String  description, Integer duration, Integer maxWin) {

        /**
         * This is the Task constructor that creates a task object based on the parameters passed into the constructor

         *
         * @param ID id of the task, type is integer
         * @param description what the task is, type is string
         * @param duration time taken for the task, type is int
         * @param maxWin the maximum hourly window the task needs to be scheduled in, type is int
         *
         */

        this.taskID = ID;
        this.description = description;
        this.duration = duration;
        this.maxWin =maxWin;

    }

    public int getTaskID(){

        /**
         * Gets the TaskID that is associated with the task it was called from
         * @return taskID, type is int
         */
        return taskID;
    }
    public int getDuration(){
        /**
         * Gets the duration that is associated with the task it was called from
         * @return duration, type is int
         */
        return duration;
    }

    public int getMaxWin(){

        /**
         * Gets the Max windoe that is associated with the task it was called from
         * @return maxWin, type is int
         */
        return maxWin;
    }
    public String getDescription(){


        /**
         * Gets the description that is associated with the task it was called from
         * @return description, type is String
         */
        return description;
    }


}
