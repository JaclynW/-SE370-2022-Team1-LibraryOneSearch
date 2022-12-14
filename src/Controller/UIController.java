package Controller;

import DataAccess.DataAccessObject;
import Model.DataTransferObject;
import Model.Database_Access_IF;
//import Model.LibrarySystem;
import View.GUISearch;
import View.GUISummaryPage;

import java.io.IOException;
import java.util.ArrayList;

import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class UIController extends JPanel {


    private static UIController instance;

    JPanel cards;
    GUISearch mainPanel;
    GUISummaryPage nextPage;

    public UIController() {
        setLayout(new BorderLayout());
        setSize(810, 510);
        cards = new JPanel(new CardLayout());

        mainPanel = new GUISearch();
        nextPage = new GUISummaryPage();
        cards.add(mainPanel, "Main");
        cards.add(nextPage, "Next");
        add(cards);
        setVisible(true);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MainPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance = new UIController();
        frame.getContentPane().add(instance);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }


    public void changeCard(String card) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, card);
    }

    public static UIController getInstance() {
        return instance;
    }


    public static void main(String[] args) throws IOException {
        /**
         * User submits search input here.
         * */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

//        String userSearchString = ; //from View
//        //Load the branches selected, and assign appropriate library system


        //DataTransferObject with DataAccessObj as parameter with user input
        DataAccessObject DAO = new DataAccessObject("Vegan", "Serra");
        DataTransferObject DTO = new DataTransferObject(DAO);
        DTO.getResultList(); //This will give a ArrayList of LibraryMaterial objects


        /**
         * Give list to GUISummaryPage when user clicks here.
         * */

        //Check for button click event

    }
}


