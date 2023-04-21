package Model;

/**
 * The {@code LibraryMaterial} class organizes the data into a single result
 * that has been scraped from the webpage via jsoup
 * @author Jaclyn Walsh
 */
public class LibraryMaterial
{
    /**
     * The author of the literature
     */
    String author = " ";
    /**
     * The title of the literature
     */
    String title = " ";
    /**
     * The ISBN number of the literature
     */
    int ISBN = 0;
    /**
     * The medium of the literature
     */
    String materialType = " ";
    /**
     * The amount of available copies
     */
    String availability = " ";
    /**
     * The hyperlink[href] for the literature
     */
    String link = " "; //this is a link the library material's info page on the library website so the user can take further action

    /**
     * Creates a new Library Material instance
     * @param title The title of the literature
     * @param author The author of the literature
     * @param matType The medium of the literature
     */
    public LibraryMaterial(String title, String author, String matType)
    {
        this.title = title;
        this.author = author;
        this.materialType = matType;
    }

    /**
     * Creates a new Library Material instance
     */
    public LibraryMaterial()
    {
        this.title = "title";
        this.author = "No author found";
        this.materialType = "Not specified";
        this.availability = "Not found";
    }
    /**
     * Gets the author name
     * @return The author name
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Sets the author name
     * @param author The author name
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Gets the title name
     * @return The title name
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title name
     * @param title The title name
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Gets the ISBN number
     * @return The ISBN number
     */
    public int getISBN() {
        return ISBN;
    }
    /**
     * Sets the ISBN number
     * @param ISBN The ISBN number
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    /**
     * Gets the medium type
     * @return The medium type
     */
    public String getMaterialType() {
        return materialType;
    }
    /**
     * Sets the medium type
     * @param materialType The medium type
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    /**
     * Gets the hyperlink of the Library Material
     * @return The hyperlink
     */
    public String getLink() {return link;}
    /**
     * Sets the hyperlink of the Library Material
     * @param link The hyperlink
     */
    public void setLink(String link) {this.link = link;}
    /**
     * Gets the number of available copies
     * @return The number of available copies
     */
    public String getAvailability() {
        return availability;
    }
    /**
     * Sets the number of available copies
     * @param availability The number of available copies
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    /**
     * List of any LibraryMaterial object' attributes are formatted and ready to print.
     * @return String of text
     */
    @Override
    public String toString() {

        return
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Material type: " + materialType + "\n" +
                "Availability: " + availability + "\n\n" ;
    }
}
