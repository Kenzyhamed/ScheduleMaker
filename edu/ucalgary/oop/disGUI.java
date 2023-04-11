package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class disGUI {
    public disGUI(String startingString) {
        JFrame frame = new JFrame("Schedule for the day");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Read from file and add contents to the panel
        File file = new File("schedule.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();

            JLabel title = new JLabel(line);
            title.setBackground(Color.YELLOW);
            title.setOpaque(true);
            title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, 20));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(title);

            while ((line = br.readLine()) != null) {
                JLabel label = new JLabel(line);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(Box.createRigidArea(new Dimension(0, 10)));
                panel.add(label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        disGUI displaySch = new disGUI("Starting String");
    }
}
