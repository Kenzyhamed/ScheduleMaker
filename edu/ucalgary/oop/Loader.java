package edu.ucalgary.oop;
import java.sql.*;
/*
this class loads  the sql database and puts each block of data into a hash map in the form of the <Integer, String[]>
the integer part is the id and the rest are stored in the string list
this is where the program starts main()!
all hashmaps are public so we can use them along the classes and in the end it calls treatement()
@author     , Kenzie Hamed UCID ________
@version    1.1
@since      1.0
 */




public class Loader{
    private Connection dbConnect;
    private ResultSet results;

    public static void main(String[] args){ //added main()
        Loader sqlLoad = new Loader();

        sqlLoad.createConnection();
        System.out.println(sqlLoad.selectTasks());



        sqlLoad.close();


    }

    public void Loader(){

    }

    public void createConnection(){

        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectTasks(){

        StringBuffer Tasks = new StringBuffer();

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TASKS");

            while (results.next()){
                System.out.println("Print results: " + results.getString("TaskID") + ", " + results.getString("Description"));

                Tasks.append(results.getString("TaskID") + ", " + results.getString("Description"));
                Tasks.append('\n');
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Tasks.toString();
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