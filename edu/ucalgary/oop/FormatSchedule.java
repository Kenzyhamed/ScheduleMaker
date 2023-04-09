package edu.ucalgary.oop;
import java.io.*;

import java.util.*;


public class FormatSchedule {

    public FormatSchedule(){
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


    }

    public void noTask(int i, Node node, FileWriter f) throws IOException {
        if(i==0 && node.getActivities()[i]==null){
            try{
                f.write("\n***No duties scheduled for this hour.***");
            }catch(IOException e){

            }

        }

    }



}