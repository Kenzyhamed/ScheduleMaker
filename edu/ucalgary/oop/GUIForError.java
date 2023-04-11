package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Micheal Tappang
 * @version 1.3
 * @since 1.0
 *
 * This GUI takes care ehen there is an error with making the schedule
 */
public class GUIForError {
    public int treatID;
    public String reason;
    public String pet_name;
    public String user_change;
    public boolean states;
    public String strhr;

    public GUIForError(String reason, String name, String hour) {
        this.reason = reason;
        this.pet_name = name;
        this.strhr = hour;
        this.user_change = "0";
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Fixing Schedule");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode("#F0EFEF"));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#F0EFEF"));

        String display = "<html><center>There are not enough workers available for the task: <b>" + this.reason +
                "</b> for <b>" + this.pet_name + "</b> at <b>" + this.strhr + "</b></center></html>";
        JLabel titleLabel = new JLabel(display, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel inputLabel = new JLabel("Enter a new starting time in the slot:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField inputField = new JTextField(20);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputLabel, BorderLayout.CENTER);
        panel.add(inputField, BorderLayout.SOUTH);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.setBackground(Color.decode("#4886E8"));
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user_change = inputField.getText();
                states = true;
                frame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#F0EFEF"));
        buttonPanel.add(submitButton);

        frame.add(panel);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public  int getSelectedHour() {
        return Integer.parseInt(this.user_change);
    }
    public boolean getStates(){return this.states;}


}
