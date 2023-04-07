package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.LinkedHashMap;




public  class ScheduleTasks extends ScheduleMaker{

    public void ScheduleTasks() {
        for(Treatment entry: Treatments.getTreatments()){
            Task task=entry.getTaskAssociated();
            Animal animal =entry.getAnimalassociated();
                ScheduleMaker putTask=new ScheduleMaker();
                putTask.Schedule(entry.getStartHour(), task.getDuration(), task.getMaxWin(), animal.getAnimalNickname(), task.getDescription());

            }}

}
