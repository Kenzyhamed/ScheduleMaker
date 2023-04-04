
/*
this class loads  the sql database and puts each block of data into a hash map in the form of the <Integer, String[]>
the integer part is the id and the rest are stored in the string list
this is where the program starts main()!
all hashmaps are public so we can use them along the classes and in the end it calls treatement()
@author     , Kenzie Hamed UCID ________
@version    1.1
@since      1.0
 */

import java.sql.DriverManager;
import java.sql.ResultSet;

public class Loader{ //deleted throws SQLException as it is thrown in main
    public static void main(String[] args){ //added main()
        String url = "jdbc:mysql://localhost:3306/EWR"; //replace "EWR" w/ the name of your MySQL database
        String user = "your_username"; //replace w/ username
        String password = "your_password"; //replace w/ password

        HashMap <Integer, String[]> animalTreatments = new HashMap<Integer, String[]>();

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet animalIds = statement.executeQuery("SELECT AnimalID FROM ANIMAL");

            while (animalIds.next()) {
                int animalId = animalIds.getInt("AnimalID");

                String[] animalTreatmentValues = new String[6];
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT AnimalNickname, AnimalSpecies, Description, Duration, MaxWindow, StartHour " +
                                "FROM ANIMALS a " +
                                "JOIN TREATMENTS t ON a.AnimalID = t.AnimalID " +
                                "JOIN TASKS ts ON t.TaskID = ts.TaskID " +
                                "WHERE a.AnimalID = ?");
                preparedStatement.setInt(1, animalId);

                ResultSet animalTreatmentResultSet = preparedStatement.executeQuery();
                if (animalTreatmentResultSet.next()) {
                    animalTreatmentValues[0] = animalTreatmentResultSet.getString("AnimalNickname");
                    animalTreatmentValues[1] = animalTreatmentResultSet.getString("AnimalSpecies");
                    animalTreatmentValues[2] = animalTreatmentResultSet.getString("Description");
                    animalTreatmentValues[3] = Integer.toString(animalTreatmentResultSet.getInt("Duration"));
                    animalTreatmentValues[4] = Integer.toString(animalTreatmentResultSet.getInt("MaxWindow"));
                    animalTreatmentValues[5] = Integer.toString(animalTreatmentResultSet.getInt("StartHour"));
                }

                animalTreatments.put(animalId, animalTreatmentValues);
            }

            connection.close();

        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }


    }

}