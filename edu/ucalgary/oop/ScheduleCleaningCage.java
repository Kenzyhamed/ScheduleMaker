package edu.ucalgary.oop;

public class ScheduleCleaningCage extends ScheduleMaker {


    public ScheduleCleaningCage() {
        ScheduleMaker clean = new ScheduleMaker();
        int durat=0;
        int starthr=000;
        for(Animal animal: Animals.getAnimals()){
            for (AnimalTypes info : AnimalTypes.values()) {
                if (info.toString().equals(animal.getAnimalType())){
                    durat = info.getCleaningDuration();
                    break;
                }
            }
            clean.Schedule(starthr, durat, 24, animal.getAnimalNickname(), "Cleaning Cage");}

    }




}
