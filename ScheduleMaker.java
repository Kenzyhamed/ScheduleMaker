import java.util.LinkedHashMap;

public class ScheduleMaker  {
    private Treatments treatments;
    private Tasks tasks;
    public ScheduleMaker(LinkedHashMap treat, LinkedHashMap task) {

        treatments = new Treatments(treat);
        tasks = new Tasks(task);


    }
}
