package edu.ucalgary.oop;

import java.util.LinkedList;



public class ScheduleFeeding extends ScheduleMaker{
    int MAX_WIN=3;
    public LinkedList<Animal> foxes=new LinkedList<Animal>();
    public LinkedList<Animal> porcupine=new LinkedList<Animal>();
    public LinkedList<Animal> coyote=new LinkedList<Animal>();
    public LinkedList<Animal> racoon=new LinkedList<Animal>();
    public LinkedList<Animal> beaver=new LinkedList<Animal>();
    int space=0;





    public ScheduleFeeding() {
        for(Animal animal: Animals.getAnimals()){
            if(animal.getAnimalType().equals("fox")){
                if(!animal.getOrphan()){
                    foxes.add(animal);
                }

            }
            else if(animal.getAnimalType().equals("coyote")){
                if(!animal.getOrphan()){
                    coyote.add(animal);
                }

            }
            else if(animal.getAnimalType().equals("racoon")){
                if(!animal.getOrphan()){
                    racoon.add(animal);
                }


            }
            else if(animal.getAnimalType().equals("porcupine")){
                if(!animal.getOrphan()){
                    porcupine.add(animal);
                }


            }
            else {
                if(!animal.getOrphan()){
                    beaver.add(animal);
                }


            }
        }
        feedFoxes();
        feedBeavers();
        feedRacoons();
        feedCoyotes();
        feedPorcupine();

    }

    public void feedBeavers(){
        feedTemplate(beaver,"beaver");

    }
    public void feedRacoons(){
        feedTemplate(racoon,"racoon");

    }
    public void feedCoyotes(){
        feedTemplate(coyote,"coyote");

    }
    public void feedPorcupine(){
        feedTemplate(porcupine,"porcupine");

    }

    public void feedFoxes(){
        feedTemplate(foxes,"fox");

    }

    public void feedTemplate(LinkedList<Animal> animalTemp,String match ){
        int maxWin=MAX_WIN;
        int prepTime=0;
        int feedDur=0;
        int strtHour = 0;
        if(!animalTemp.isEmpty()){
            for(AnimalTypes animal:AnimalTypes.values()){
                if(animal.toString().equals(match)){
                    strtHour = animal.getFeedingStrtHr();
                    feedDur = animal.getFeedingDuration();
                    prepTime = animal.getPrepTime();
                }
            }
            int amountAnimals=0;
            String[] animalToFeed;
            for(Node node: Time.getTime()){
                if (strtHour == node.getData()){
                    if (containsNull(node.getActivities())) {
                        amountAnimals=(space-prepTime)/feedDur;
                        if(amountAnimals>animalTemp.size()){
                            amountAnimals=animalTemp.size();}
                        int duration= prepTime+ (amountAnimals*feedDur);
                        if (space >= duration) {
                            int delete =amountAnimals;
                            animalToFeed= new String[delete];
                            for(Animal type: animalTemp){
                                if(amountAnimals!=0 && type !=null) {
                                    animalToFeed[amountAnimals-1] = type.getAnimalNickname();
                                    amountAnimals -= 1;
                                }
                            }

                            for(int i =0; i<delete; i++){
                                    animalTemp.set(i, null);
                            }
                            String filling = "Feeding - " + match + " (" + animalToFeed.length + ":" +  String.join(",", animalToFeed) + ")";
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


    public boolean containsNull(String[] values) {
        boolean amount = false;
        space = 0;
        for (String o : values) {
            if (o == null) {
                amount = true;
                space += 1;
            }
        }
        return amount;
    }

}
