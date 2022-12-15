package Controller;

import DataAccess.DataAccessObject;
import Model.DataTransferObject;
//import Model.LibrarySystem;
import Model.LibraryMaterial;
import View.GUISearch;
import View.GUISummaryPage;

import java.io.IOException;

import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class UIController extends JPanel {


    private static UIController instance;

    JPanel cards;
    GUISearch guiSearch;
    GUISummaryPage guiSummary;
    private static ArrayList<LibraryMaterial> libraryM;

    public UIController() {
        setLayout(new BorderLayout());
        setSize(810, 510);
        cards = new JPanel(new CardLayout());
        guiSearch = new GUISearch();
        guiSummary = new GUISummaryPage();
        cards.add(guiSearch, "Main");
        cards.add(guiSummary, "Summary");
        add(cards);
        setVisible(true);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Library OneSearch");
        Image icon = new ImageIcon("src/books.png").getImage();
        frame.setIconImage(icon);

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


    public static void libraryOneSearch(String searchString, String librarySystem) throws IOException {
        //DataTransferObject with DataAccessObj as parameter with user input
        DataAccessObject DAO = new DataAccessObject(searchString, librarySystem);
        DataTransferObject DTO = new DataTransferObject(DAO);
        GUISummaryPage.setResultsList(DTO.getResultList());

    }

    public static void setLibraryM(ArrayList<LibraryMaterial> list){
        libraryM = list;

    }
    public static ArrayList<LibraryMaterial> getLibraryM(){
        return libraryM;
    }


    public static void main(String[] args) throws IOException {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });



    }
}


