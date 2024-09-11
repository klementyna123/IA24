import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    //page 1 where there is label and 2 button 
    JFrame page1Frame;
    JPanel page1Panel;
    JButton buttonLogFeeding;
    JButton buttonViewHistory;

    //page 2 so viewing the starters 
    JFrame page2Frame;
    JPanel page2Panel;
    JButton GoBacktoPage1;

    public GUI() {

        //for page 1 
        page1Frame = new JFrame();
        page1Frame.setSize(600,600);
        page1Panel = new JPanel();
        page1Panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        page1Panel.setLayout(new BorderLayout()); 
        page1Frame.setVisible(true);

        // Adding page 1 components
        JLabel welcomeLabel = new JLabel("Welcome to the sourdough app!", SwingConstants.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout()); // Use FlowLayout for buttons
        buttonLogFeeding = new JButton("Log feeding");
        buttonViewHistory = new JButton("View Starter history");
        buttonViewHistory.addActionListener(this);
        buttonLogFeeding.addActionListener(this);
        buttonPanel.add(buttonLogFeeding);
        buttonPanel.add(buttonViewHistory);

        page1Panel.add(welcomeLabel, BorderLayout.NORTH);
        page1Panel.add(buttonPanel, BorderLayout.CENTER);
        page1Frame.add(page1Panel);


        //FOR PAGE 2
        page2Frame = new JFrame();
        page2Frame.setSize(600,600);
        page2Panel = new JPanel(new FlowLayout()); // Use FlowLayout for consistency
        GoBacktoPage1 = new JButton("Go back to main screen");
        GoBacktoPage1.addActionListener(this);
        page2Panel.add(GoBacktoPage1);

        page2Frame.add(page2Panel);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e) {
        //button to go from main screen to starter history
        if (e.getSource() == buttonViewHistory) {
            page2Frame.setVisible(true);
            page1Frame.setVisible(false);
        }
        //button to go from viewing starters to main screen
        else if(e.getSource() == GoBacktoPage1) {
            page2Frame.setVisible(false);
            page1Frame.setVisible(true);
        }
    }
}
