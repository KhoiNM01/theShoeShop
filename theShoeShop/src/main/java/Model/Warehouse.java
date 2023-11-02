package Model;

import java.sql.Date;

public class Warehouse {
    private int productsID;
    private String nameProduct;
    private Date importDate;
    private String nameSupplier;
    private String nameBrand;
    private int quantity;
    private int size;
    private String color;
    private float price;

    public Warehouse(int productsID, String nameProduct, Date importDate, String nameSupplier, String nameBrand, int quantity, int size, String color, float price) {
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
    
    public int getProductID() {
        return productsID;
    }

    public void setProductID(int productsID) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
