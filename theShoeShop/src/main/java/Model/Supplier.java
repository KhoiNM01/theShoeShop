package Model;

public class Supplier {
    private Integer idSupplier;
    private String nameSupplier;
    private String phoneSupplier;
    private String emailSupplier;
    private String addressSupplier;
    private Integer cateID;

    public Supplier(Integer idSupplier, String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier, Integer cateID) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.phoneSupplier = phoneSupplier;
        this.emailSupplier = emailSupplier;
        this.addressSupplier = addressSupplier;
        this.cateID = cateID;
    }

    public Supplier() {
        
    }

    public Integer getSupplierID() {
        return idSupplier;
    }

    public void setSupplierID(Integer idSupplier) {
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

    public Integer getCategoryID() {
        return cateID;
    }

    public void setCategoryID(Integer cateID) {
        this.cateID = cateID;
    }
}
