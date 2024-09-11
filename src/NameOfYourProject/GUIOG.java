import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUIOG implements ActionListener{

    //this constructor just makes a window nothing more lol that is a lie IT SWITCHES BETWEEN PAGES wow
    int count = 0;
 
    //for frame 1
    JLabel label1;
    JFrame frame;
    JButton button;
    JButton countclicksButton;

    //for frame 2
    JFrame frame2;
    JButton goBackButton;


    public GUIOG() {

        //frame 1 so first thing that user sees 
        frame = new JFrame();
        //creating a button that leads to the page of feedings
        button = new JButton("LOG feeding for today");
        countclicksButton = new JButton("click count");

        //adding a label 
        label1 = new JLabel("Welcome to the sourdough app");
        //creating a panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel.setLayout(new GridLayout());
        //adding a button to the panel 
        panel.add(button);
        //giving the button function
        button.addActionListener(this);

        //setting position of a button 
        button.setLocation(17,31);
        //adding a label to the panel 
        panel.add(label1);

        panel.add(countclicksButton);
        countclicksButton.addActionListener(this);
        countclicksButton.setLocation(30,70);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sourdough App");
        frame.pack();
        frame.setVisible(true);


        //second frame so what we use the button to switch to 

        frame2 = new JFrame();
        JLabel label2 = new JLabel("this is window 2");
        JPanel panel2 = new JPanel();
        goBackButton = new JButton("Go back to page 1");
        goBackButton.addActionListener(this);
        panel2.add(goBackButton);
        panel2.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel2.setLayout(new GridLayout());
        panel2.add(label2);
        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Sourdough App");
        frame2.pack();
        frame2.setVisible(false);
    }


    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e){
        //to have multiple buttong we need if and the if works seperately for each button
        //goes to page 2 
        if (e.getSource() == button){
            frame2.setVisible(true);
            frame.setVisible(false);
        }
        //counts clicks <3 
        else if(e.getSource() == countclicksButton){
            count++;
            label1.setText("Number of clicks: " + count);

        }
        //goes back to page 1
        else if(e.getSource() == goBackButton){
            frame.setVisible(true);
            frame2.setVisible(false);
        }
        
        

    
    }
    
}
