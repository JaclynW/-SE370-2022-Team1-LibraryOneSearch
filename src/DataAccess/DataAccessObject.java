package DataAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//TODO: This class should inherit from the Database_Access_IF class.
//This class is what interacts with the UIController which gives user input to database, here.
// This class also send info back via the DataTransfer Object

public class DataAccessObject
{
    String SEARCH_STRING = " ";
    String librarySystem = " ";
    //Most of the time, the url for a library has the search string sandwiched within the url.
    // If this is the case we need the end of the url in this variable.
    String URLFront = " ";
    String URLEnd = " ";


    public DataAccessObject(String SEARCH_STRING, String librarySystem)
    {
        this.SEARCH_STRING = SEARCH_STRING;
        this.librarySystem = librarySystem;

        //Set library system to appropriate search link
        switch (librarySystem)
        {
            case "Serra":
                this.URLFront = "https://cbcl.sdp.sirsi.net/client/en_US/home/search/results?qu=";
                this.URLEnd = "&te=";
                break;
            case "SDPublic":
                this.URLFront = "https://sandiego.bibliocommons.com/v2/search?query=";
                this.URLEnd = "&searchType=smart&page=1";
                break;
            case "SDCounty":
                this.URLFront = "https://sdcl.bibliocommons.com/v2/search?query=";
                this.URLEnd = "&searchType=smart";
                break;
            case "Oceanside":
                this.URLFront = "https://oceanside.iii.com/iii/encore/search/C__S";
                this.URLEnd = "__Orightresult__U?lang=eng&suite=def";
                break;
        }

    }

    public String getSEARCH_STRING() {return SEARCH_STRING;}

    public void setSEARCH_STRING(String SEARCH_STRING) {this.SEARCH_STRING = SEARCH_STRING;}

    public String getLibrarySystem() {return librarySystem;}

    public void setLibrarySystem(String librarySystem) {this.librarySystem = librarySystem;}

    public ArrayList<String> getResults() throws IOException
    {
        //Testing: Grab the title of the Carlsbad Library website
//        Document doc = Jsoup.connect("https://library.carlsbadca.gov/").get();
//        String title = doc.title();
//        System.out.println("title is: " + title);

        List<String> libraryM = new ArrayList<String>(); //This is to hold the result list
        Document doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();


        boolean nextPagePresent = true;

//        do {
            //Grab results by their element type and put in a list
            for (Element tracks : doc2.select("div.displayDetailLink")) {
//            System.out.println(tracks.getAllElements());
//            System.out.println(tracks.getElementsByTag("title"));

                for (Element links : tracks.getElementsByTag("a")) {
                    libraryM.add(links.text());
                }
            }

//        } while (nextPagePresent);

        //Show what we found
        int numOfResultsFound = libraryM.size();
        System.out.println("Number of results found for " + SEARCH_STRING + " : " + numOfResultsFound + "\n");

        int length = libraryM.size();
        for (int i = 0; i < length; i++) {
            System.out.println(libraryM.get(i));
        }

        return (ArrayList<String>) libraryM;
    }



}
