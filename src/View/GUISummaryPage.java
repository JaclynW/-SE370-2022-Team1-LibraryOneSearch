package View;
import Controller.UIController;
import Model.DataTransferObject;
import Model.LibraryMaterial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class GUISummaryPage extends JPanel implements ActionListener {

    private JButton back, viewResults;
    private JPanel top, center, bottom, libraryResult, listPanel;
    private JLabel title, resultNumber, matStart, matTitle, matAuthor, matType, matAvail;
    private int numberOfResults;
    private JTextField textField;
    private static ArrayList<LibraryMaterial> libraryMat = new ArrayList<>();

    public GUISummaryPage() {

        setLayout(new BorderLayout());
        top = new JPanel(new BorderLayout());
        // Add a centered title to the top of the screen
        title = new JLabel("Summary Page");
//        numberOfResults = UIController.getLibraryM().size();
//        resultNumber = new JLabel( numberOfResults + " results found. ");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        top.add(title, BorderLayout.PAGE_START );
//        top.add(resultNumber, BorderLayout.CENTER);
        viewResults = new JButton("Click to show results");
        top.add(viewResults, BorderLayout.PAGE_END);
        add(top, BorderLayout.PAGE_START );

        //Show the results
        center = new JPanel();
        viewResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (LibraryMaterial material: libraryMat)
                {

                    libraryResult = new JPanel();
                    matTitle = new JLabel(material.getTitle());
                    matAuthor = new JLabel(material.getAuthor());
                    matType = new JLabel(material.getMaterialType());
                    matAvail = new JLabel(material.getAvailability());
//                    matStart = new JLabel(material.toString());
                    libraryResult.add(matTitle);
                    libraryResult.add(matAuthor);
                    libraryResult.add(matType);
                    libraryResult.add(matAvail);
                    center.add(libraryResult);

                }
                revalidate();
                repaint();
                setVisible(true);
            }
        });


        add(center, BorderLayout.CENTER);

        bottom = new JPanel();
        back = new JButton("Back");
        textField = new JTextField(20);
        bottom.add(back);
        add(bottom, BorderLayout.SOUTH);
        back.addActionListener(this);

        setVisible(true);
        setSize(400, 500);
    }

    public static void setResultsList(ArrayList<LibraryMaterial> lm){
        libraryMat = lm;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            UIController.getInstance().changeCard("Back");
        }


    }
}