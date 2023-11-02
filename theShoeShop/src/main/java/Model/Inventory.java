package Model;

public class Inventory {
    private int productsID;
    private int quantitySold;
    private int inventory;

    public Inventory(int productsID, int quantitySold, int inventory) {
        this.productsID = productsID;
        this.quantitySold = quantitySold;
        this.inventory = inventory;
    }

    public Inventory() {
        
    }

    public int getProductID() {
        return productsID;
    }

    public void setProductID(int productsID) {
        this.productsID = productsID;
    }

    public int getSoldQuantity() {
        return quantitySold;
    }

    public void setSoldQuantity(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    } 
}
