package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VolGUI implements ActionListener {

    private String reason;
    private JFrame frame;
    private JLabel reasonLabel;
    private JButton confirmButton;
    public boolean state;

    public VolGUI(String reason) {
        /**
         * Constructor for VOLGUI
         * @param reason type is String
         */
        this.reason = reason;
        this.state = false;
        createGUI();


    }

    public void createGUI() {
        /**
         * Creates GUI interface and presentation

         */
        frame = new JFrame("NEED A VOLUNTEER");
        frame.setSize(1000, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        reasonLabel = new JLabel("You need a volunteer for this hour: " + reason);
        reasonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(reasonLabel);

        confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); }

    public void actionPerformed(ActionEvent e) {
        /**
         * Handles what happens after pressing confirm
         * @param e , type is ActionEvent
         */
        if (e.getSource() == confirmButton) {
            JOptionPane.showMessageDialog(frame, "Thank you for confirming!");
            frame.dispose();
            this.state = true;
        }
    }
    public boolean getState(){
        /**
         * Gets the state
         * @return state, type is boolean
         */

        return this.state;
    }


}
