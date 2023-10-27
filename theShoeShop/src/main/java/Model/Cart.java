package Model;

public class Cart {

    private Integer accountID;
    private Integer productsID;
    private Integer quantity;
    private Integer maCart;

    public Cart(Integer accountID, Integer productsID, Integer quantity, Integer maCart) {
        this.accountID = accountID;
        this.productsID = productsID;
        this.quantity = quantity;
        this.maCart = maCart;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getProductID() {
        return productsID;
    }

    public void setProductID(Integer productsID) {
        this.productsID = productsID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCart() {
        return maCart;
    }

    public void setCart(Integer maCart) {
        this.maCart = maCart;
    }
}
