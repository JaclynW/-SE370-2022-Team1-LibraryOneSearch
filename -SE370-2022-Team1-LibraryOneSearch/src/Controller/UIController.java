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

/**
 * The {@code UIController} class is responsible for creating/controlling the GUI
 * and retrieving data from the model
 * @author Jaclyn Walsh
 */
public class UIController extends JPanel {
    /**
     * The UI Controller instance
     */
    private static UIController instance;
    /**
     * Organizes each page of the GUI
     */
    JPanel cards;
    /**
     * The GUI Search instance
     */
    GUISearch guiSearch;
    /**
     * The GUI Summary Page instance
     */
    GUISummaryPage guiSummary;
    /**
     * The array of Library Material
     */
    private static ArrayList<LibraryMaterial> libraryM;
    /**
     * Creates a new UIController and sets its properties
     */
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
    /**
     * Creates a GUI JFrame and sets its properties
     */
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
    /**
     * Flips to the specified page of the JPanel
     * @param card the name of the target card
     */
    public void changeCard(String card) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, card);
    }
    /**
     * Gets the UIController instance
     * @return The instance of UIController
     */
    public static UIController getInstance() {
        return instance;
    }
    /**
     * Creates a DataAccessObject from user input and a corresponding DataTransferObject.
     * Transfers result list data to GUISummaryPage instance
     * @param searchString
     * @param librarySystem
     */
    public static void libraryOneSearch(String searchString, String librarySystem) throws IOException {
        //DataTransferObject with DataAccessObj as parameter with user input
        DataAccessObject DAO = new DataAccessObject(searchString, librarySystem);
        DataTransferObject DTO = new DataTransferObject(DAO);
        GUISummaryPage.setResultsList(DTO.getResultList());
    }
    /**
     * Sets the current array of Library Material
     * @param list The array of Library Material to use
     */
    public static void setLibraryM(ArrayList<LibraryMaterial> list){
        libraryM = list;
    }
    /**
     * Gets the current array of Library Material
     * @return The array of Library Material
     */
    public static ArrayList<LibraryMaterial> getLibraryM(){
        return libraryM;
    }
    /**
     * Entry point of the program. Responsible for
     * @param args Unused
     */
    public static void main(String[] args) throws IOException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


