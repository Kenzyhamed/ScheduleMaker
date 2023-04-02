import java.util.HashMap;

public class Tasks {
    private HashMap<Integer, String[]> orderedTasks= new HashMap<Integer, String[]>();
    private Integer taskID;
    private String description;
    private Integer duration;
    private Integer maxWindow;

    public Integer getTaskID(){
        return taskID;
    }

    public String getDescription(){
        return description;
    }

    public Integer getDuration(){
        return duration;
    }
    public Integer getMaxWindow(){
        return maxWindow;
    }

    public void setTaskID(Integer tskID){
        this.taskID=tskID;

    }

    public void setDescription(String desc){
        this.description=desc;
    }

    public void setMaxWindow(Integer tskmaxWin){
        this.maxWindow=tskmaxWin;

    }
    public void setDuration(Integer drat){
        this.duration=drat;

    }


    public void orderTasks(){
        /*orders hashmap based on maxWindow*/


    }
}
