package Model;

public class Product {
    private String id;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    private String supplyId;

    public Product(String id, String name, Double price, String description, Integer quantity, String supplyId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.supplyId = supplyId;
    }

    public Product() {
        
    }

    public String getProductId() {
        return id;
    }

    public void setProductId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId;
    }
}
