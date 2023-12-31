/**
 * Class that describes the Order object which is placed by each user between a client and a product
 * @param id uniquely identifies each order
 * @param clientId that represents the client that wants to buy the product
 * @param productId represents the item to be bought
 * @param quantity represents the amount of that specific item.
 */

package ro.tuc.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that describes the Order object which is placed by each user between a client and a product
 */

public class Order {

    private int id;
    private int clientId;
    private int productId;
    private int quantity;

    public Order(){

    }
    public Order(int id, int clientId, int productId, int quantity){
        super();
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }
    public Order(int clientId, int productId, int quantity){
        super();
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id +
                ", clientId=" + clientId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ']';
    }
}