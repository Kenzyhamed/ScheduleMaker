package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ScheduleMaker {
    private Treatments treatments;
    private Tasks tasks;
    private Animals animals;
    private Time hoursInDay;
    private ScheduleFeeding feeding;

    int amount;

    public ScheduleMaker(){

    }
    public ScheduleMaker(LinkedHashMap<Integer, ArrayList<String>> treat, LinkedHashMap<Integer, ArrayList<String>> task, LinkedHashMap<Integer, ArrayList<String>>animal) {
        hoursInDay = new Time();
        animals = new Animals(animal);
        treatments = new Treatments(treat);
        tasks = new Tasks(task);


    }

    public void Schedule(int strthr, int durat, int mxW,String name, String desc ) {
        int startHr = strthr;
        int maxWin = mxW;
        int duration = durat;
        String description = desc;
        String animalName = name;
        for (Node node : Time.getTime()) {
            if (startHr == node.getData()) {
                if (containsNull(node.getActivities())) {
                    if (amount >= duration) {
                        String filling = description + "(" + animalName + ")";
                        for (int i = 0; i < node.activities.length; i++) {
                            if ((node.activities[i] == null || node.activities[i].isEmpty()) && (duration != 0)) {
                                node.activities[i] = filling;
                                duration -= 1;
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                }
            } else if (maxWin > 1) {
                startHr += 1;
                maxWin = -1;
            } else {
                //ScheduleCantBeMade("Task Id:for animal(s) Animals.getAnimals().get(anid).get(1) doesnt fit in the schedule");}}
            }}}


    public boolean containsNull (String[]values){
        boolean space = false;
        amount = 0;
        for (String o : values) {
            if (o == null) {
                space = true;
                amount += 1;
            }
        }
        return space;
    }


    public void ScheduleVolunteer () {
        for (Node node : Time.getTime()) {
            int count = 0;
            for (String space : node.activities) {
                if (space != null) {
                    count += 1;
                }
            }
            if (count > 60) {
                node.setVolunteer(true);
            }

        }
    }
}
