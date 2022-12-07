package Controller;


import DataAccess.DataAccessObject;
import Model.DataTransferObject;

import java.io.IOException;
import java.util.ArrayList;

public class UIController
{
    public static void main(String[] args) throws IOException
    {

        //Check for user changes in GUI

        //User submits search input
        //DataTransferObject with DataAccessObj as parameter with user input
        DataAccessObject DAO = new DataAccessObject("vegan", "Serra");
        DataTransferObject DTO = new DataTransferObject(DAO);
        DTO.getResultList(); //This will give a ArrayList of LibraryMaterial objects

        //Give list to GUISummaryPage when user clicks
        //Check for button click event

    }

}
