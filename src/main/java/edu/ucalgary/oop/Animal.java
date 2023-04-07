package edu.ucalgary.oop;

public class Animal {

    private int animalID;
    public String  animalNickname;
    public String animalType;
    public String animalSpecies;
    public boolean orphan;


    public Animal(int ID, String  Nickname, String Type, String Species, boolean orphan) {
        this.animalID = ID;
        this.animalNickname = Nickname;
        this.animalType = Type;
        this.animalSpecies =Species;
        this.orphan =orphan;

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
        return orphan;
    }



}
