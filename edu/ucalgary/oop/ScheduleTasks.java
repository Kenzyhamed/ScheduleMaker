package edu.ucalgary.oop;


public  class ScheduleTasks extends ScheduleMaker{

    public ScheduleTasks() {
        for(Treatment entry: Treatments.getTreatments()){
            Task task=entry.getTaskAssociated();
            Animal animal =entry.getAnimalassociated();
            ScheduleMaker putTask=new ScheduleMaker();
            putTask.Schedule(entry.getStartHour(), task.getDuration(), task.getMaxWin(), animal.getAnimalNickname(), task.getDescription());

            }}

}
