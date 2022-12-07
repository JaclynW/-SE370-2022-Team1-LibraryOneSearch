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

//TODO: This class should inherit from the Database_Access_IF class.
//This class is what interacts with the UIController which gives user input to database, here.
// This class also send info back via the DataTransfer Object


public class DataAccessObject implements Database_Access_IF
{
    String SEARCH_STRING = " ";
    String librarySystem = " ";
    String URLFront = " ";
    String URLEnd = " ";
    ArrayList<LibraryMaterial> libraryM;
//    List<String> libraryM; //This is to hold the result list


    public DataAccessObject(String SEARCH_STRING, String librarySystem)
    {
        this.SEARCH_STRING = SEARCH_STRING;
        this.librarySystem = librarySystem;
        libraryM = new ArrayList<LibraryMaterial>();
//        libraryM = new ArrayList<String>();

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

    public void getResultBio(Document doc2) throws IOException
    {
        for (Element tracks2 : doc2.select("div.results_bio"))
        {
            LibraryMaterial lm = new LibraryMaterial();

            String title = tracks2.select("div.INITIAL_TITLE_SRCH").text();
            lm.setTitle(title);
            String author = tracks2.select("div.INITIAL_AUTHOR_SRCH").text();
            if(author.isEmpty())
            {
                lm.setAuthor("N/A");
            }
            else
            {
                lm.setAuthor(author);
            }

            String matType = tracks2.select("div.formatType, div.formatText").text();
            lm.setMaterialType(matType);
            String avail = tracks2.select("availableDiv0").text();
            lm.setAvailability(avail);

//            for (Element title : tracks2.select("div.INITIAL_TITLE_SRCH"))
//            {
//
//                lm.setTitle(title.text());
//
//                for (Element author: tracks2.select("div.INITIAL_AUTHOR_SRCH"))
//                {
//                    lm.setAuthor(author.text());
//
//                    for (Element matType: tracks2.select("div.formatType, div.formatText"))
//                    {
//                        lm.setMaterialType(matType.text());
////                        for (Element avail: tracks2.select("div.availableDiv0"))
//
//                    }
//                    for (Element avail: tracks2.getElementsByTag("availableDiv0"))
//                    {
//
//                        lm.setAvailability(avail.text());
//                    }
//
//                }
//
//                this.libraryM.add(lm);
//            }
            this.libraryM.add(lm);

        }
    }
    //Crawls the html
    public void getTitleResults(Document doc2) throws IOException
    {
        //Find all titles
//        for (Element tracks : doc2.select("div.displayDetailLink"))
//        {
////            System.out.println(tracks);
//            //start crawling the html by tag
//            for (Element links : tracks.getElementsByTag("a"))
//            {
//                this.libraryM.add(links.text());
//
//            }
//        }

        //Find all authors or call numbers
//        for (Element tracks2 : doc2.select("div.displayElementWrapper"))
//        for (Element tracks2 : doc2.select("div.results_every_four"))
//        for (Element tracks2 : doc2.select("div.results_bio"))
        for (Element tracks2 : doc2.select("div.PREFERRED_CALLNUMBER"))
        {

//            this.libraryM.add(tracks2.text());
//            LibraryMaterial lm = new LibraryMaterial(tracks2.id("title"), tracks2.id(""));
//            tracks2.select("div#");
//            String resultBio = tracks2.text();

            LibraryMaterial lm = new LibraryMaterial(tracks2.text(), "null", "null");
            this.libraryM.add(lm);

        }
//        displayElementText text-p highlightMe PREFERRED_CALLNUMBER
//        displayElementText text-p highlightMe INITIAL_AUTHOR_SRCH

        //class of availability #: availableDiv availableCountSection
        // class of hold #: availableDiv holdsCountSection
        //class of copies #: availableDiv copiesCountSection
    }

    public void getMaterialTypeResults(Document doc2 ) throws IOException
    {
        for (Element tracks2 : doc2.select("div.INITIAL_AUTHOR_SRCH"))
        {
            LibraryMaterial lm = new LibraryMaterial("null","null" , tracks2.text());
            this.libraryM.add(lm);
        }
    }

    public void getAuthorResults(Document doc2 ) throws IOException
    {
        for (Element tracks2 : doc2.select("div.INITIAL_AUTHOR_SRCH"))
        {
            LibraryMaterial lm = new LibraryMaterial("null", tracks2.text(), "null");
            this.libraryM.add(lm);
        }
    }

    //Updates url and prints list of results to console
    public ArrayList<LibraryMaterial> getResults() throws IOException
    {

        Document doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
//        getTitleResults(doc2);
//        getAuthorResults(doc2);
        getResultBio(doc2);

        //For the next result pages
        int URLMath = 0;
        while(URLMath < 24)
        {
            //Update url
            URLMath += 12;
            URLEnd = "&rw=" + URLMath + "&isd=true"; //For Serra testing
            doc2 = Jsoup.connect(URLFront + SEARCH_STRING + URLEnd).referrer(URLFront + SEARCH_STRING + URLEnd).get();
//            getTitleResults(doc2);
//            getAuthorResults(doc2);
            getResultBio(doc2);
        }

        //Show what we found
        int numOfResultsFound = libraryM.size();
        System.out.println("Number of results found for " + SEARCH_STRING + " : " + numOfResultsFound + "\n");

        int length = libraryM.size();
        for (int i = 0; i < length; i++)
        {
            System.out.println(libraryM.get(i));
        }

//        return (ArrayList<String>) libraryM;
        return libraryM;
    }




}
