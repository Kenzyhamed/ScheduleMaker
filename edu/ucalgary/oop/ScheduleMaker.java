package edu.ucalgary.oop;
import java.util.LinkedHashMap;


public class ScheduleMaker  {
    private Treatments treatments;
    private Tasks tasks;
    private Time hoursInDay;
    public ScheduleMaker(LinkedHashMap treat, LinkedHashMap task) {

        hoursInDay = new Time();
        treatments = new Treatments(treat);
        tasks = new Tasks(task);


    }
}
