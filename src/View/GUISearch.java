package View;

import Controller.UIController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
import java.util.*;

public class GUISearch extends JPanel implements ActionListener {
    private JPanel searchScreen, top, center, bottom;
    private JButton search, summary;
    private JTextField textField;
    private JCheckBox branchOption1, branchOption2, branchOption3, branchOption4, branchOption5, branchOption6;
    private JLabel title;
    private String searchString, selectedBranch;
    private ArrayList<String> selectedBranches;


    public GUISearch() {

        setLayout(new BorderLayout());

        // Create the individual cards (i.e., the different screens)
        searchScreen = new JPanel();
        searchScreen.setLayout(new BorderLayout());

        // Add a centered title to the top of the screen
        title = new JLabel("Library OneSearch");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        searchScreen.add(title, BorderLayout.PAGE_START);

        search = new JButton("Search");
        branchOption1 = new JCheckBox("Carlsbad Cole");
        branchOption2 = new JCheckBox("Carlsbad Dove");
        branchOption3 = new JCheckBox("Oceanside Main");
        branchOption4 = new JCheckBox("Oceanside Mission");
        branchOption5 = new JCheckBox("Vista County");
        branchOption6 = new JCheckBox("San Diego County");


        textField = new JTextField(20);


        top = new JPanel();
        top.add(searchScreen);

        searchScreen.add(textField, BorderLayout.PAGE_END);
        add(top, BorderLayout.NORTH);

        center = new JPanel();
        center.add(branchOption1);
        center.add(branchOption2);
        center.add(branchOption3);
        center.add(branchOption4);
        center.add(branchOption5);
        center.add(branchOption6);

        add(center, BorderLayout.CENTER);

        bottom = new JPanel();
        bottom.add(search);
        add(bottom, BorderLayout.PAGE_END);
        search.addActionListener(this);
        setVisible(true);
        setSize(400, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            //get search query
            searchString = textField.getText();

            //get selected library branch(s)
            if (branchOption1.isSelected()) {
                selectedBranch = "Serra";
            }
            if (branchOption2.isSelected()) {
                selectedBranch = "Serra";
            }
            if (branchOption3.isSelected()) {
                selectedBranch = "Oceanside";
            }

            //This is the upgrade to a list of library branches
//            selectedBranches = new ArrayList<>();
//            if (branchOption1.isSelected()) {
//                selectedBranches.add(branchOption1.getText());
//            }
//            if (branchOption2.isSelected()) {
//                selectedBranches.add(branchOption2.getText());
//            }
//            if (branchOption3.isSelected()) {
//                selectedBranches.add(branchOption3.getText());
//            }

            //search
            if(searchString.isEmpty()){
                System.out.println("Enter something to search.");
            }

            try {
                UIController.libraryOneSearch(searchString, selectedBranch);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //make a View Summary Page button appear
            summary = new JButton("View Summary Page");
            bottom.add(summary);
            add(bottom,BorderLayout.PAGE_END);
            revalidate();
            repaint();
            setVisible(true);

            //Check for click on summary button
            summary.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UIController.getInstance().changeCard("Summary");
                }
            });

        }
    }

}