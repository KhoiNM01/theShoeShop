package Model;

public class Inventory {
    private Integer productsID;
    private Integer quantitySold;
    private Integer inventory;

    public Inventory(Integer productsID, Integer quantitySold, Integer inventory) {
        this.productsID = productsID;
        this.quantitySold = quantitySold;
        this.inventory = inventory;
    }

    public Inventory() {
        
    }

    public Integer getProductID() {
        return productsID;
    }

    public void setProductID(Integer productsID) {
        this.productsID = productsID;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    } 
}
