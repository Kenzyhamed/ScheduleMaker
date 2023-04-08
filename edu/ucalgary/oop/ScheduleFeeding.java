package edu.ucalgary.oop;

public class ScheduleFeeding extends ScheduleMaker{

    public ScheduleFeeding() {
        int durat=0;
        int starthr=0;
        for(Animal animal: Animals.getAnimals()){
            if(animal.getOrphan()){break;};
            ScheduleMaker putFeeding=new ScheduleMaker();
            for (AnimalTypes info : AnimalTypes.values()) {
                if (info.toString().equals(animal.getAnimalType())){
                    durat = info.getFeedingDuration();
                    starthr= info.getFeedingStrtHr();
                    break;
                }
            }
            putFeeding.Schedule(starthr, durat, 3, animal.getAnimalNickname(), "Feeding");}
    }
}
