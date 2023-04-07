package edu.ucalgary.oop;

public class ScheduleCleaningCage extends ScheduleMaker {
    public int OTHER_DURATION=5;
    public int PORCUPINE_DURATION=10;

    public void CleaningCage() {
        ScheduleMaker clean = new ScheduleMaker();
        int durat=0;
        int starthr=000;
        for(Animal animal: Animals.getAnimals()){
            ScheduleMaker putFeeding=new ScheduleMaker();
            for (AnimalTypes info : AnimalTypes.values()) {
                if (animal.toString() == animal.getAnimalType()){
                    durat = info.getCleaningDuration();
                    break;
                }
            }
            putFeeding.Schedule(starthr, durat, 24, animal.getAnimalNickname(), "Cleaning Cage");}

    }




}
