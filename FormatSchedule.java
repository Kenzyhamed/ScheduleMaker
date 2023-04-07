package edu.ucalgary.oop;
import java.io.*;

import java.util.*;


public class FormatSchedule {
    LinkedList<Node> schedule = Time.getTime();

    public FormatSchedule(){
        try{
            File file = new File("schedule.txt");
            FileWriter f = new FileWriter("schedule.txt");
            for(Node node: Time.getTime()){
                int after=node.getData() % 100;
                int before =node.getData() / 100;
                f.write( before+ ":"+after);
                if(node.getVolunteer()==true){
                    f.write("[+ backup volunteer]");
                }
                f.write("\n");
                f.write("* " );


            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}