package Model;

import DataAccess.DataAccessObject;

import java.io.IOException;
import java.util.ArrayList;

public class DataTransferObject
{
    ArrayList<LibraryMaterial> results = new ArrayList<LibraryMaterial>();
    DataAccessObject DAO = new DataAccessObject("Default","Default");

    public DataTransferObject(DataAccessObject DAO) throws IOException
    {
        this.DAO = DAO;
        //TODO: I think this is the class where the string results are made into LibraryMaterial objects to be put in a list and sent to UIContoller.
        this.results = DAO.getResults();
    }

    public ArrayList<LibraryMaterial> getResultList()
    {
        return results;
    }
}
