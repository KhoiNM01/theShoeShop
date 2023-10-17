package Model;

public class Cart {

    private String accountId;
    private String productId;
    private Integer quantity;
    private Float subtotal;

    public Cart(String accountId, String productId, Integer quantity, Float subtotal) {
        this.accountId = accountId;
        this.productId = productId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }
}
