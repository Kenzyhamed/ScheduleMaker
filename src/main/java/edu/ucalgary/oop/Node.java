package edu.ucalgary.oop;

/**
 * @author Kenzy Hamed UCID:30140355
 * @version 1.8
 * @status 1.0
 *
 */
public class Node {
    private boolean volunteer;
    public String[] activities;
    public final int data;


    public Node(boolean volunteer, String[] activities, int data) {
        this.volunteer = volunteer;
        this.activities = activities;
        this.data = data;

    }

    public boolean getVolunteer(){
        return volunteer;
    }

    public int getData(){
        return data;
    }

    public String[] getActivities(){
        return activities;
    }


    public void setVolunteer(boolean vol){
        this.volunteer=vol;
    }



}
