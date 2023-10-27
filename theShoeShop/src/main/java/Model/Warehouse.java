package Model;

import java.sql.Date;

public class Warehouse {
    private Integer productsID;
    private String nameProduct;
    private Date importDate;
    private String nameSupplier;
    private String nameBrand;
    private Integer quantity;
    private Integer size;
    private String color;
    private Float price;

    public Warehouse(Integer productsID, String nameProduct, Date importDate, String nameSupplier, String nameBrand, Integer quantity, Integer size, String color, Float price) {
        this.productsID = productsID;
        this.nameProduct = nameProduct;
        this.importDate = importDate;
        this.nameSupplier = nameSupplier;
        this.nameBrand = nameBrand;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Warehouse() {
        
    }
    
    public Integer getProductID() {
        return productsID;
    }

    public void setProductID(Integer productsID) {
        this.productsID = productsID;
    }

    public String getProductName() {
        return nameProduct;
    }

    public void setProductName(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public String getSupplierName() {
        return nameSupplier;
    }

    public void setSupplierName(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getBrandName() {
        return nameBrand;
    }

    public void setBrandName(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
