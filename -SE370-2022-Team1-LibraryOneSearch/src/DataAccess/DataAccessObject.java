package DataAccess;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Model.Database_Access_IF;
import Model.LibraryMaterial;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;

/**
 * The {@code DataAccessObject} class is what interacts with the UIController which gives user input to database, here.
 * This class also send info back via the DataTransfer Object.
 * @author Jaclyn Walsh
 */
public class DataAccessObject implements Database_Access_IF
{
    /**
     * The search string from user input
     */
    private String SEARCH_STRING = " ";
    /**
     * The name of the specified Library
     */
    private String librarySystem = " ";
    /**
     * The section of URL before the search string
     */
    private String URLFront = " ";
    /**
     * The section of URL after the search string
     */
    private String URLEnd = " ";
    /**
     * The array of Library Material
     */
    private ArrayList<LibraryMaterial> libraryM;
    /**
     * Creates a new DataAccessObject and sets its properties
     * @param SEARCH_STRING The search string from user input
     * @param librarySystem The specified Library from user input
     */
    public DataAccessObject(String SEARCH_STRING, String librarySystem)
    {
        this.SEARCH_STRING = SEARCH_STRING;
        this.librarySystem = librarySystem;
        libraryM = new ArrayList<LibraryMaterial>();

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
    /**
     * Gets the current search string
     * @return the search string
     */
    public String getSEARCH_STRING() {return SEARCH_STRING;}
    /**
     * Sets the current search string
     * @param SEARCH_STRING The search string to use
     */
    public void setSEARCH_STRING(String SEARCH_STRING) {this.SEARCH_STRING = SEARCH_STRING;}
    /**
     * Gets the current Library System
     * @return the Library System
     */
    public String getLibrarySystem() {return librarySystem;}
    /**
     * Sets the current Library System
     * @param librarySystem The Library System to use
     */
    public void setLibrarySystem(String librarySystem) {this.librarySystem = librarySystem;}
    /**
     * Uses JSoup to grab a copy of the HTML of the given library search page,
     * then looks for a div in the HTML that is called "div.results_bio".
     * The result bio is the name of the divs that hold all the information about
     * a given library material result.
     * Once this div is found sub divs are located for the title and author of a library material,
     * and this info is saved in a LibraryMaterial object.
     * @param doc2 This is the HTML document retrieved with JSoup for the given library database url.
     */
    public void getResultBio(Document doc2) throws IOException
    {
        if (librarySystem == "Oceanside") {
            for (Element tracks2 : doc2.select("div.dpBibTitle")) {
                LibraryMaterial lm = new LibraryMaterial();
                String title = tracks2.select("span.title").text();
                lm.setTitle(title);
                String author = tracks2.select("div.dpBibAuthor").text();
                if(author.isEmpty()) {
                    lm.setAuthor("N/A");
                } else {
                    lm.setAuthor(author);
                }
                String matType = tracks2.select("div.recordDetailValue").text();
                lm.setMaterialType(matType);

                this.libraryM.add(lm);
            }
        } else {

            for (Element tracks2 : doc2.select("div.results_bio")) {
                LibraryMaterial lm = new LibraryMaterial();
                String title = tracks2.select("div.INITIAL_TITLE_SRCH").text();
                lm.setTitle(title);
                String author = tracks2.select("div.INITIAL_AUTHOR_SRCH").text();
                if (author.isEmpty()) {
                    lm.setAuthor("N/A");
                } else {
                    lm.setAuthor(author);
                }

                String matType = tracks2.select("div.formatType, div.formatText").text();
                lm.setMaterialType(matType);
                String avail1 = tracks2.select("ercAvailableCountNumber").text();
                System.out.println(avail1);
//            boolean avail = tracks2.select("el#availableNumber_hitlist0").hasText();
                //availableNumber ercAvailableCountNumber
//            System.out.println("A: " + avail);
                lm.setAvailability(avail1 + " ");

                this.libraryM.add(lm);
            }
        }
    }
    /**
     * Updates url and prints list of results to console. Uses
     * getResultBio method to aggregate results.
     * @return ArrayList of Library Material
     */
    public ArrayList<LibraryMaterial> getResults() throws IOException
    {
        if (librarySystem == "Oceanside") {
            Document doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
            getResultBio(doc2);

            //For the next result pages
            int URLMath = 0;
            while(URLMath < 3)
            {
                //Update url
                URLMath++;
                URLEnd = "__P" + URLMath + "__Orightresult__U__X0?lang=eng&suite=def"; //For Oceanside testing
                doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
                getResultBio(doc2);
            }
            return libraryM;
        } else {

            Document doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
            getResultBio(doc2);

            //For the next result pages
            int URLMath = 0;
            while (URLMath < 24) {
                //Update url
                URLMath += 12;
                URLEnd = "&rw=" + URLMath + "&isd=true"; //For Serra testing
                doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
                getResultBio(doc2);
            }
            return libraryM;
        }
    }
}
