package edu.ucalgary.oop;

public class Task {
    private int taskID;
    public String  description;
    public int duration;
    public int maxWin;


    public Task(int ID, String  description, Integer duration, Integer maxWin) {
        this.taskID = ID;
        this.description = description;
        this.duration = duration;
        this.maxWin =maxWin;

    }

    public int getTaskID(){
        return taskID;
    }
    public int getDuration(){return duration;}
    public void setDuration(int duration){}
    public int getMaxWin(){
        return maxWin;
    }
    public String getDescription(){
        return description;
    }

    public void setMaxWin(int mw) {this.maxWin=mw;}
}
