package edu.ucalgary.oop;

public class Animal {

    private int animalID;
    public String  animalNickname;
    public String animalType;
    public String animalSpecies;
    public boolean orphan;


    public Animal(int ID, String  Nickname, String Type, String Species) {
        this.animalID = ID;
        this.animalNickname = Nickname;
        this.animalType = Type;
        this.animalSpecies =Species;
        getOrphan();

    }

    public int getAnimalID(){
        return animalID;
    }
    public String getAnimalNickname(){return animalNickname;}
    public String getAnimalSpecies(){
        return animalSpecies;
    }
    public String getAnimalType(){
        return animalType;
    }
    public boolean getOrphan(){

        for(Integer anID : Treatments.getOrderedTreatments().keySet()){

            if(Integer.parseInt(Treatments.getOrderedTreatments().get(anID).get(0))==this.animalID){
                if(Treatments.getOrderedTreatments().get(anID).get(1).equals("1")){
                    this.orphan=true;
                }
                else{
                    this.orphan=false;
                }

            }
        }
        return orphan;
    }



}
