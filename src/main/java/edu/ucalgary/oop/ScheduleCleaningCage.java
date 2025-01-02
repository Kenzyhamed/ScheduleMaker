package edu.ucalgary.oop;

import java.util.LinkedList;

public class ScheduleCleaningCage extends ScheduleMaker {
    int MAX_WIN=24;
    int STRT_HR=000;

    public LinkedList<Animal> foxes=new LinkedList<Animal>();
    public LinkedList<Animal> porcupine=new LinkedList<Animal>();
    public LinkedList<Animal> coyote=new LinkedList<Animal>();
    public LinkedList<Animal> racoon=new LinkedList<Animal>();
    public LinkedList<Animal> beaver=new LinkedList<Animal>();
    public void cleanBeavers(){
        cleanTemplate(beaver,"beaver");

    }
    public void cleanRacoons(){

        cleanTemplate(racoon,"racoon");

    }
    public void cleanCoyotes(){
        cleanTemplate(coyote,"coyote");

    }
    public void cleanPorcupine(){
        cleanTemplate(porcupine,"porcupine");

    }

    public void cleanFoxes(){
        cleanTemplate(foxes,"fox");

    }

    public ScheduleCleaningCage() {

        for(Animal animal: Animals.getAnimals()){
            if(animal.getAnimalType().equals("fox")){
                foxes.add(animal);
            }
            else if(animal.getAnimalType().equals("coyote")){
                coyote.add(animal);
            }
            else if(animal.getAnimalType().equals("racoon")){
                racoon.add(animal);
            }
            else if(animal.getAnimalType().equals("porcupine")){
                porcupine.add(animal);
            }
            else {
                beaver.add(animal);
            }



        }
        cleanFoxes();
        cleanBeavers();
        cleanRacoons();
        cleanCoyotes();
        cleanPorcupine();






    }

    public void cleanTemplate(LinkedList<Animal>animalTemp, String match ){
        int maxWin=MAX_WIN;
        int Dur=0;
        int prepTime=0;
        int strtHour = STRT_HR;
        if(!animalTemp.isEmpty()){
            for(AnimalTypes animal:AnimalTypes.values()){
                if(animal.toString().equals(match)){
                    Dur = animal.getCleaningDuration();
                }
            }
            int amountAnimals=0;
            String[] animalToClean;
            for(Node node: Time.getTime()){
                if (strtHour == node.getData()){
                    if (containsNull(node.getActivities())) {
                        amountAnimals=(amount-prepTime)/Dur;
                        if(amountAnimals>animalTemp.size()){
                            amountAnimals=animalTemp.size();}
                        int duration= prepTime + (amountAnimals*Dur);
                        if (amount >= duration) {
                            int delete =amountAnimals;
                            animalToClean= new String[delete];
                            for(Animal type: animalTemp){
                                if(amountAnimals!=0 && type !=null) {
                                    animalToClean[amountAnimals-1] = type.getAnimalNickname();
                                    amountAnimals -= 1;
                                }
                            }

                            for(int i =0; i<delete; i++){
                                animalTemp.set(i, null);
                            }
                            String filling = "Cleaning Cage - " + match + " (" + animalToClean.length + ":" +  String.join(",", animalToClean) + ")";
                            fill( node,duration, filling);
                        }

                    }
                    else if (maxWin > 1) {
                        strtHour += 1;
                        maxWin = -1;}
                }
            }

        }
    }




}
