/**
 * Class that describes the Product object used in the application that represents the object that can be ordered by a client
 * @param id that represents the unique identifier of each object
 * @param name that represents the name of each product
 * @param price which is a double type number that represents the cost of a product
 * @param quantity which represents the quantity, or stock, left in the "shop" for each object.
 */
package ro.tuc.model;
/**
 * Class that describes the Product object used in the application that represents the object that can be ordered by a client
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(){

    }
    public Product(int id, String name, double price, int quantity){
        super();
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
    public Product (String name, double price, int quantity){
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", quantity=" + quantity +
                '}';
    }
}

