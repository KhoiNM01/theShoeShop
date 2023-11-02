package Model;

public class Cart {

    private int accountID;
    private int productsID;
    private int quantity;
    private int maCart;

    public Cart(int accountID, int productsID, int quantity, int maCart) {
        this.accountID = accountID;
        this.productsID = productsID;
        this.quantity = quantity;
        this.maCart = maCart;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productsID;
    }

    public void setProductID(int productsID) {
        this.productsID = productsID;
    }

    public int getItemQuantity() {
        return quantity;
    }

    public void setItemQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCart() {
        return maCart;
    }

    public void setCart(int maCart) {
        this.maCart = maCart;
    }
}
