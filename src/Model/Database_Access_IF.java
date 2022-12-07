package Model;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;

public interface Database_Access_IF
{
    String getSEARCH_STRING();
    void setSEARCH_STRING(String SEARCH_STRING);
    String getLibrarySystem();
    void setLibrarySystem(String librarySystem);
//    void getResultsHelper(Document doc2) throws IOException;
    ArrayList<LibraryMaterial> getResults() throws IOException;

}