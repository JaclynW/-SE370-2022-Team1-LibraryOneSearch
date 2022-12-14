package Controller;

import DataAccess.DataAccessObject;
import Model.DataTransferObject;
import Model.Database_Access_IF;
//import Model.LibrarySystem;

import java.io.IOException;
import java.util.ArrayList;

public class UIController
{
    public static void main(String[] args) throws IOException
    {

        /**
         * Check for user changes in GUI here.
         * */



        /**
         * User submits search input here.
         * */

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
