import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    // Main frame to hold both panels
    JFrame mainFrame;
    JPanel panelContainer;
    CardLayout cardLayout;

    // Page 1 where there is label and 2 buttons 
    JPanel page1Panel;
    JButton buttonLogFeeding;
    JButton buttonViewHistory;

    // Page 2 so viewing the starters 
    JPanel page2Panel;
    JButton GoBacktoPage1;
    JButton buttonFedStarter;
    JButton buttonStarterDone;
    JLabel feedStarterLabel;  // Reference to the label that needs updating

    // Page 3 so where starters are saved 
    JPanel page3Panel;
    JButton gobackpage3;
    JLabel page3label;

    // Page 4 so the place where you add details of your starter 
    JPanel page4Panel;
    JButton gotomenu4;
    JLabel pages4Label;
    JButton buttonsaveDetails;

    public GUI() {

        // Main frame
        mainFrame = new JFrame();
        mainFrame.setSize(600, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Sourdough App");

        // Use CardLayout to switch between panels
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);  // Container for all pages

        // For page 1 
        page1Panel = new JPanel();
        page1Panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        page1Panel.setLayout(new BorderLayout());

        // Page 1 buttons creating + adding action
        buttonLogFeeding = new JButton("Log feeding");
        buttonViewHistory = new JButton("View Starter history");
        buttonViewHistory.addActionListener(this);
        buttonLogFeeding.addActionListener(this);

        // Creating a label for page 1
        JLabel welcomeLabel = new JLabel("Welcome to the sourdough app!", SwingConstants.CENTER); // Centered the label

        // Panel for the buttons to arrange them side by side
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());  // This will place the buttons next to each other
        buttonPanel.add(buttonLogFeeding);
        buttonPanel.add(buttonViewHistory);

        // Adding things to the panel --> so to the screen
        page1Panel.add(welcomeLabel, BorderLayout.NORTH);  // Label at the top
        page1Panel.add(buttonPanel, BorderLayout.CENTER);  // Buttons in the center

        // FOR PAGE 2
        page2Panel = new JPanel();
        page2Panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        page2Panel.setLayout(new BorderLayout());  // Using BorderLayout for precise positioning

        // Go back to menu button for page 2
        GoBacktoPage1 = new JButton("Go back to menu");
        GoBacktoPage1.addActionListener(this);
        page2Panel.add(GoBacktoPage1, BorderLayout.SOUTH);

        // Creating and adding new label and buttons to page 2
        JPanel feedPanel = new JPanel();
        feedPanel.setLayout(new FlowLayout());  // Layout for the new label and buttons

        feedStarterLabel = new JLabel("FEED YOUR STARTER!!!", SwingConstants.CENTER);
        JLabel additionalLabel = new JLabel("Your starter is n days old", SwingConstants.CENTER); // New label

        buttonFedStarter = new JButton("I fed my starter");
        buttonStarterDone = new JButton("My starter is done");

        buttonStarterDone.addActionListener(this);

        // Adding action listener to buttonFedStarter
        buttonFedStarter.addActionListener(e -> feedStarterLabel.setText("You've already fed your starter"));

        // Adding the new label and buttons to feedPanel
        feedPanel.add(feedStarterLabel);
        feedPanel.add(additionalLabel);  // Added new label
        feedPanel.add(buttonFedStarter);
        feedPanel.add(buttonStarterDone);

        // Add feedPanel to the center of page 2
        page2Panel.add(feedPanel, BorderLayout.CENTER);

        // FOR PAGE 3
        page3Panel = new JPanel();
        page3Panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        page3Panel.setLayout(new BorderLayout());  
        page3label = new JLabel("This is where the history of your starters will be displayed");
        page3Panel.add(page3label, BorderLayout.CENTER);  // Change to CENTER

        // Page 3 button to go back to the menu
        gobackpage3 = new JButton("Go back to menu");
        gobackpage3.addActionListener(this);
        page3Panel.add(gobackpage3, BorderLayout.SOUTH);

        // For page 4
        
        page4Panel = new JPanel();
        page4Panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        page4Panel.setLayout(new GridBagLayout());  // Changed layout to GridBagLayout

       

        pages4Label = new JLabel("This is where you will be able to add the details of your starter");
        page4Panel.add(pages4Label);

        JLabel flour = new JLabel("Type of flour:");
        page4Panel.add(flour);

        JLabel water = new JLabel("Amount of water added per feeding:");
        page4Panel.add(water);

        JLabel notes = new JLabel("Notes about your starter:");
        page4Panel.add(notes);

        buttonsaveDetails = new JButton("Save details");
        page4Panel.add(buttonsaveDetails);

       
        gotomenu4 = new JButton("Go back to menu");
        gotomenu4.addActionListener(this);
        page4Panel.add(gotomenu4);

        // Add all pages to the panelContainer
        panelContainer.add(page1Panel, "Page 1");
        panelContainer.add(page2Panel, "Page 2");
        panelContainer.add(page3Panel, "Page 3");
        panelContainer.add(page4Panel, "Page 4");

        // Add the panelContainer to the main frame
        mainFrame.add(panelContainer);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e) {
        // Button to go from main screen to page 2
        if (e.getSource() == buttonLogFeeding) {
            cardLayout.show(panelContainer, "Page 2");  // Switch to page 2
        }
        // Button to go from page 2 to page 3
        else if (e.getSource() == buttonViewHistory) {
            cardLayout.show(panelContainer, "Page 3");  // Switch to page 3
        }
        // Button to go from page 2 to page 1
        else if (e.getSource() == GoBacktoPage1) {
            cardLayout.show(panelContainer, "Page 1");  // Switch to page 1
        }
        // Button to go from page 3 to page 1
        else if (e.getSource() == gobackpage3) {
            cardLayout.show(panelContainer, "Page 1");  // Switch back to page 1
        }
        //button from page 2 to page 4
        else if (e.getSource() == buttonStarterDone) {
            cardLayout.show(panelContainer, "Page 4");  // Switch back to page 1
        }
        // Button to go from page 4 to page 1
        else if (e.getSource() == gotomenu4) {
            cardLayout.show(panelContainer, "Page 1");  // Switch back to page 1
        }
    }
}