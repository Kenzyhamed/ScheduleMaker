package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class GUIScheduleMade extends JFrame implements ActionListener{

    JRadioButton yesButton;
    JRadioButton noButton;
    Boolean noPressed = false;
    JLabel inputLabel = new JLabel("Have you called a backup volunteer?");

    public GUIScheduleMade(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());


        yesButton = new JRadioButton("yes");
        noButton = new JRadioButton("no");

        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        inputLabel.setBounds(150,100,200,25);

        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        this.add(inputLabel);
        this.add(yesButton);
        this.add(noButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yesButton)
        {
            this.dispose();
        }
        if(e.getSource() == noButton)
        {
            this.noPressed = true;
            this.dispose();
        }

    }

    public static void promptSchedule() throws FileNotFoundException {
        int hour = 0;
        for(Node node: Time.getTime())
        {

            if(node.getVolunteer() == true)
            {
                    GUIScheduleMade x = new GUIScheduleMade();
                    String label = String.format("Did you call a backup volunteer for hour %d", hour);
                    x.inputLabel.setText(label);
                    x.pack();
                    x.setLocationRelativeTo(null);
                    x.setVisible(true);
                    x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    x.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            synchronized (Loader.class) {
                                Loader.class.notify(); // notify the waiting thread
                            }
                        }
                    });
                    try {
                        synchronized (Loader.class) {
                            Loader.class.wait(); // wait for user input
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(x.noPressed == false)
                    {
                        break;
                    }

            }


            hour++;

        }

        try {
            File myObj = new File("schedule.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }}