package Model;

public class Order {
    private int accountID;
    private String companyName;
    private String address;
    private String city;
    private String phone;
    private int maOrder;

    public Order(int accountID, String companyName, String address, String city, String phone, int maOrder) {
        this.accountID = accountID;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.maOrder = maOrder;
    }

    public Order() {
        
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(int maOrder) {
        this.maOrder = maOrder;
    }

    
}
