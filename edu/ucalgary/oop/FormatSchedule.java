package edu.ucalgary.oop;
import java.io.*;

import java.util.*;


public class FormatSchedule {
    LinkedList<Node> schedule = Time.getTime();

    public FormatSchedule(){
        try{


            FileWriter f = new FileWriter("schedule.txt");

            for(Node node: Time.getTime()){

                int before =node.getData() / 100;
                f.write( before+ ":00 \n");
                String current="";
                if(node.getVolunteer()==true){
                    f.write("[+ backup volunteer]");
                }
                f.write("\n");





            }
            f.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}