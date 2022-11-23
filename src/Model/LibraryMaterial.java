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

    /**
     * Constructor
     */
    public LibraryMaterial()
    {
        //TODO: complete constructor. Should there be two?
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

    @Override
    public String toString() {
        return "LibraryMaterial{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", materialType='" + materialType + '\'' +
                ", libSystem=" + libSystem +
                '}';
    }
}
