package Model;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code Database_Access_IF} interface class holds the getter/setter methods
 * for the DataAccessObject
 * @author Jaclyn Walsh
 */
public interface Database_Access_IF
{
    String getSEARCH_STRING();
    void setSEARCH_STRING(String SEARCH_STRING);
    String getLibrarySystem();
    void setLibrarySystem(String librarySystem);
    void getResultBio(Document doc2) throws IOException;
    ArrayList<LibraryMaterial> getResults() throws IOException;

}