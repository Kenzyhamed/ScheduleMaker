
package edu.ucalgary.oop;
import java.util.*;
import java.sql.*;

/**
this class loads  the sql database and puts each block of data into a hash map in the form of the <Integer, String[]>
the integer part is the id and the rest are stored in the string list
this is where the program starts main()!
all hashmaps are public so we can use them along the classes and in the end it calls treatement()
@author     Kenzy Hamed UCID 30140355
@version    1.4
@since      1.0
 */




public class Loader{
    private Connection dbConnect;
    private ResultSet results;
    private static LinkedHashMap<Integer, ArrayList<String>> treatments= new LinkedHashMap<Integer, ArrayList<String>>();
    private static LinkedHashMap<Integer, ArrayList<String>> animals= new LinkedHashMap<Integer, ArrayList<String>>();
    private static LinkedHashMap<Integer, ArrayList<String>> tasks= new LinkedHashMap<Integer, ArrayList<String>>();

    public static void main(String[] args){ //added main()
        Loader sqlLoad = new Loader();

        sqlLoad.createConnection();
        sqlLoad.selectTasks();
        sqlLoad.selectAnimals();
        sqlLoad.selectTreatments();
        sqlLoad.close();



        ScheduleMaker schedule = new ScheduleMaker(treatments,tasks, animals);
        ScheduleTasks task = new ScheduleTasks();
        ScheduleFeeding feed = new ScheduleFeeding();
        ScheduleCleaningCage cleanCage = new ScheduleCleaningCage();
        schedule.ScheduleVolunteer();
        FormatSchedule fom = new FormatSchedule();





    }

    public void Loader(){

    }

    public void createConnection(){

        try{

            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "root", "Kenzyhamed1122004!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  LinkedHashMap<Integer, ArrayList<String>> selectTasks(){




        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TASKS");

            while (results.next()){
                ArrayList<String> other=new ArrayList<String>();
                other.add(results.getString("Description"));
                other.add(results.getString("Duration"));
                other.add(results.getString("maxWindow"));
                tasks.put(Integer.parseInt(results.getString("TaskID")), other);

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }


    public  LinkedHashMap<Integer, ArrayList<String>> selectAnimals(){

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM ANIMALS");

            while (results.next()){
                ArrayList<String> other=new ArrayList<String>();
                other.add(results.getString("AnimalNickname"));
                other.add(results.getString("AnimalSpecies"));
                animals.put(Integer.parseInt(results.getString("AnimalID")), other);

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animals;
    }

    public  LinkedHashMap<Integer, ArrayList<String>> selectTreatments(){

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS");
            Integer i=0;
            while (results.next()){
                i++;
                ArrayList<String> other=new ArrayList<String>();
                other.add(results.getString("AnimalID"));
                other.add(results.getString("TaskID"));
                other.add(results.getString("StartHour"));

                treatments.put(i, other);

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return treatments;
    }

    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
