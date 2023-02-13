public class Product {

    private int _ID;    // ID is fixed once set (no setters)

    public String _name;
    public double _price;

    Product(int ID, String name, double price) {
        this._ID = ID;
        this._name = name;
        this._price = price;
    }

}
