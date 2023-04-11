
package edu.ucalgary.oop;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.sql.*;

/**
this Loader class loads  the sql database and puts each block of data into a hash map in the form of the <Integer, String[]>
the integer part is the id and the rest are stored in the string list this is where the program starts.
@author     Kenzy Hamed UCID 30140355
@version    1.8
@since      1.0
 */




public class Loader{
    private static Connection dbConnect;
    private static ResultSet results;
    private static PreparedStatement p = null;
    private static LinkedHashMap<Integer, ArrayList<String>> treatments= new LinkedHashMap<Integer, ArrayList<String>>();
    private static LinkedHashMap<Integer, ArrayList<String>> animals= new LinkedHashMap<Integer, ArrayList<String>>();
    private static LinkedHashMap<Integer, ArrayList<String>> tasks= new LinkedHashMap<Integer, ArrayList<String>>();

    public static void main(String[] args){

        /**
         * This is the main function that connects to the database and retrieves all of the information then makes a new object of
         * the class schedule maker and passes in all the linked hashmaps, it also makes objects out of Schedule feeding/cleaning cage/tasks
         * so that they are put in the schedule, then it determines if there are volunteers needed by calling the schedule volunteer function in schedule maker
         * abd finally calls format schedule so that a file with the schedule can be created.
         */
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
        /**
         * Default constructor doesn't do anything, just used to restart program without exiting
         */

    }

    public static void createConnection(){
        /**
         * creates connection to database
         */

        try{

            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "root", "Kenzyhamed1122004!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void  updateTask(int treatID, String newStartHr){
        /**
         * updates sql databases based on parameters passed to metjod
         * @param treatID treatment id that needs to be updated
         *
         * @param newStartHR start hour that user inouts to change
         */
        try {
            createConnection();
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS");

            String update="update treatments set StartHour=" + newStartHr + " where TreatmentID=" + treatID;
            p = dbConnect.prepareStatement(update);
            p.execute();
            myStmt.close();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  LinkedHashMap<Integer, ArrayList<String>> selectTasks(){
        /**
         * retrieves tasks from sql table and puts it in linked hashmap
         * @returns tasks type LinkedHashMap<Integer, ArrayList<String>>
         */

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
        /**
         * retrieves animals from sql table and puts it in linked hashmap
         * @returns animals type LinkedHashMap<Integer, ArrayList<String>>
         */

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
        /**
         * retrieves treatments from sql table and puts it in linked hashmap
         * @returns treatments type LinkedHashMap<Integer, ArrayList<String>>
         */

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
        /**
         * closes sql database access
         */
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
