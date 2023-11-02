package Model;

public class Supplier {
    private int idSupplier;
    private String nameSupplier;
    private String phoneSupplier;
    private String emailSupplier;
    private String addressSupplier;
    private int cateID;

    public Supplier(int idSupplier, String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier, int cateID) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.phoneSupplier = phoneSupplier;
        this.emailSupplier = emailSupplier;
        this.addressSupplier = addressSupplier;
        this.cateID = cateID;
    }

    public Supplier() {
        
    }

    public int getSupplierID() {
        return idSupplier;
    }

    public void setSupplierID(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return nameSupplier;
    }

    public void setSupplierName(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getSupplierPhone() {
        return phoneSupplier;
    }

    public void setSupplierPhone(String phoneSupplier) {
        this.phoneSupplier = phoneSupplier;
    }

    public String getSupplierEmail() {
        return emailSupplier;
    }

    public void setSupplierEmail(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getSupplierAddress() {
        return addressSupplier;
    }

    public void setSupplierAddress(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public int getCategoryID() {
        return cateID;
    }

    public void setCategoryID(int cateID) {
        this.cateID = cateID;
    }
}
