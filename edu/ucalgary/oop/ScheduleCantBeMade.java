package edu.ucalgary.oop;





public class ScheduleCantBeMade {

    public ScheduleCantBeMade(int treatID, String newStartHr){
        Loader.updateTask(treatID, newStartHr);
        Loader newSchedule = new Loader();

}}
