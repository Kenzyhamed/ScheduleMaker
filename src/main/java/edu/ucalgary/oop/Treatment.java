package edu.ucalgary.oop;

public class Treatment {

    private int TanimalID;
    public int  TtaskID;
    public int startHour;

    public Animal animalAssociated;
    public Task taskAssociated;



    public Treatment(int anID, int  tasID, int strthr) {
        this.TanimalID = anID;
        this.TtaskID=tasID;
        this.startHour = (strthr * 100);

        for(Animal animalNode:Animals.getAnimals()){
            if(anID==animalNode.getAnimalID()){
                this.animalAssociated=animalNode;
            }
        }

        for(Task taskNode:Tasks.getTasks()){
            if(tasID==taskNode.getTaskID()){
                this.taskAssociated=taskNode;
            }
        }

    }


    public int getStartHour(){return startHour;}
    public int getTAnimalID(){
        return TanimalID;
    }
    public Animal getAnimalassociated(){
        return animalAssociated;
    }
    public Task getTaskAssociated(){
        return taskAssociated;
    }
    public void setStartHour(int strthr){this.startHour=strthr;}

}
