public class Animals {

    private Integer AnimalID;
    private String AnimalNickname;
    private String AnimalSpecies;

    public Integer getAnimalID(){
        return AnimalID;
    }

    public String getAnimalNickname(){
        return AnimalNickname;
    }

    public String getAnimalSpecies(){
        return AnimalSpecies;
    }

    public void setAnimalID(Integer anID){
        this.AnimalID=anID;

    }

    public void setAnimalNickname(String anNick){
        this.AnimalNickname=anNick;
    }

    public void setAnimalSpecies(String anSpec){
        this.AnimalSpecies=anSpec;

    }
}
