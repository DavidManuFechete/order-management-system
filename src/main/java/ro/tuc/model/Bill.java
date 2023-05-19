package ro.tuc.model;

/**
 * Represents the immutable object on which details of an order are set for each of them. It's also stored in the
 * database and shown on the orders GUI.
 * @param id uniquely identifies each bill
 * @param quantity represents the quantity bought by the client which will be specified on the bill
 * @param productName represents the product bough
 * @param clientName finally the name of the client that placed that order.
 */
public record Bill(int id, int quantity, String productName, String clientName) {

    @Override
    public String toString() {
        return "Bill for client : " + clientName +
                "\nProduct bought : " + productName + "\nQuantity = " + quantity;
    }
}
