package edu.ucalgary.oop;

/**
 * @author Kenzy Hamed 30140355
 * @version 1.3
 * @since 1.0
 *
 * The Node class makes Node objects that represents each hour of the day. When called that contains all the information needed to identify that hour.
 * Such as all the activities that will happen in that hour, the data which is the hour number, and a boolean variable volunteer that indicates if a backup volunteer is needed.
 */
public class Node {
    private boolean volunteer;
    public String[] activities;
    public final int data;


    public Node(boolean volunteer, String[] activities, int data) {
        /**
         *This is the Node constructor that creates an hour/node object based on the parameters passd to the constructor.
         *
         * @param volunteer the backup volunteer status
         * @param activities the list of activities to happen in that hour
         * @param data the hour number
         */

        this.volunteer = volunteer;
        this.activities = activities;
        this.data = data;

    }

    public boolean getVolunteer(){
        /**
         * Gets the volunteer status that is associated with the node/hour it was called from.
         * @return volunteer indicator of whether backup volunteer is needed or not, type is boolean
         */
        return volunteer;
    }

    public int getData(){
        /**
         * Gets the data/hour number that is associated with the node/hour it was called from.
         * @return data the hour number, type is int
         */
        return data;
    }

    public String[] getActivities(){
        /**
         * Gets all the activities that will happen throughout the hour that it was called from.
         * @return activities, type is String[]
         */
        return activities;
    }


    public void setVolunteer(boolean vol){
        /**
         * Sets the volunteer status that is associated with the node/hour it was called from depending on the passed parameter vol.
         * @param vol volunteer status, type is boolean
         */
        this.volunteer=vol;
    }



}
