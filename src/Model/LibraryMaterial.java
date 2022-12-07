package Model;

/**
 * LibraryMaterial represents a single library result.
 */
public class LibraryMaterial
{
    String author = " ";
    String title = " ";
    int ISBN = 0;
    String materialType = " ";
    LibrarySystem libSystem;
    String link = " "; //this is a link the library material's info page on the library website so the user can take further action

    /**
     * Constructor
     */
    public LibraryMaterial(String title, String author, String matType)
    {
        this.title = title;
        this.author = author;
        this.materialType = matType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public LibrarySystem getLibSystem() {
        return libSystem;
    }

    public void setLibSystem(LibrarySystem libSystem) {
        this.libSystem = libSystem;
    }

    public String getLink() {return link;}

    public void setLink(String link) {this.link = link;}

    @Override
    public String toString() {
        return "LibraryMaterial{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", materialType='" + materialType + '\'' +
                ", libSystem=" + libSystem +
                ", link='" + link + '\'' +
                '}';
    }
}
