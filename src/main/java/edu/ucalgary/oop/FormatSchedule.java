package edu.ucalgary.oop;
import java.io.*;

/** This class formats the schedule and outputs it*/


public class FormatSchedule {



    public FormatSchedule(){
        /**
         *This is the Format schedule constructor that creates a schedule.txt file and then iterates through the times linked list
         * to obtain information for each hour and then write it into the file. It does this by iterating through the node linked list which contains all the times, formats the time
         *  then determines if a volunteer is required then it will add a backup volunteer alert next to the time
         *  Then it will look  at   the activity list and group all the identical duties that come exactly after each other and write it in the file
         *  it will check however if the activities list is empty so that it can oupt no task duties for that hour.
         */
        try{


            FileWriter f = new FileWriter("schedule.txt");

            for(Node node: Time.getTime()){

                int before =node.getData() / 100;
                f.write( "\n\n"+before+ ":00  ");

                String current="";
                if(node.getVolunteer()==true){
                    f.write("[+ backup volunteer]");
                }
                f.write("\n----------------\n");
                String activity="";
                for(int i=0; i< node.getActivities().length; i++) {
                    try{
                        noTask(i, node,f);
                        if(node.activities[i]==null){
                            break;
                        }
                        else if (node.getActivities().length - i == 1) {
                            activity = node.activities[i];
                            f.write("\n * " + activity);
                            break;

                        } else if (node.activities[i].equals(node.activities[i + 1]) ) {
                            activity = node.activities[i];
                        } else {
                            f.write("\n * " + activity);
                            activity = node.activities[i + 1];
                        }
                    }catch(NullPointerException e){

                    }
                }

            }
            f.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        disGUI display = new disGUI("start");

    }

    public void noTask(int i, Node node, FileWriter f) throws IOException {
        /**
         * noTask class checks to see if the activities string list is empty and if it is at the start position
         * and if theose are tru it wites in the file under the time that there aren't any task.
         * @param firstpos  the position that the activity list is on
         * @param node the current hour it is iterating over
         * @param f the file being created
         * @throws IOException , if cant write in file throws exception
         */
        if(i==0 && node.getActivities()[i]==null){
            try{
                f.write("\n***No duties scheduled for this hour.***");
            }catch(IOException e){

            }

        }

    }



}