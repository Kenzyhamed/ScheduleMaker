package edu.ucalgary.oop;

/**
 * @author Kenzy Hamed UCID:30140355
 * @version 1.4
 * @status 1.0
 *
 */
public enum AnimalTypes {

    COYOTE{
        public String toString() {return "coyote";}
        public String getType(){ return "crepuscular";}
        public Integer getFeedingDuration(){ return 5;}
        public Integer getCleaningDuration(){ return 5;}
        public Integer getFeedingStrtHr(){ return 1900;}
        public Integer getPrepTime(){ return 10;}},
    FOX{
        public String toString() {return "fox";}
        public String getType(){ return "nocturnal";}
        public Integer getFeedingDuration(){ return 5;}
        public Integer getCleaningDuration(){ return 5;}
        public Integer getFeedingStrtHr(){ return 000;}
        public Integer getPrepTime(){ return 5;}},
    PORCUPINE{
        public String toString() {return "porcupine";}
        public String getType(){ return "crepuscular";}
        public Integer getFeedingDuration(){ return 5;}
        public Integer getCleaningDuration(){ return 10;}
        public Integer getFeedingStrtHr(){ return 1900;}
        public Integer getPrepTime(){ return 0;}},
    RACCOON{
        public String toString() {return "raccoon";}
        public String getType(){ return "nocturnal";}
        public Integer getFeedingDuration(){ return 5;}
        public Integer getCleaningDuration(){ return 5;}
        public Integer getFeedingStrtHr(){ return 000;}
        public Integer getPrepTime(){ return 0;}
    },
    BEAVER{
        public String toString() {return "beaver";}
        public String getType(){ return "diurnal";}
        public Integer getFeedingDuration(){ return 5;}
        public Integer getCleaningDuration(){ return 5;}
        public Integer getFeedingStrtHr(){ return 800;}
        public Integer getPrepTime(){ return 0;}};




    public abstract String getType();
    public abstract Integer getFeedingDuration();
    public abstract Integer getCleaningDuration();
    public abstract Integer getFeedingStrtHr();
    public abstract Integer getPrepTime();
}




