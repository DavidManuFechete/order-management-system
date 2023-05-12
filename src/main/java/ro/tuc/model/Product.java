package ro.tuc.model;

public class Product {

    private int id;
    private int name;
    private float price;
    private int quantity;

    public Product(int id, int name, float price, int quantity){
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
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

