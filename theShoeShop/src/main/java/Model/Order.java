package Model;

public class Order {
    private Integer accountID;
    private String companyName;
    private String address;
    private String city;
    private String phone;
    private Integer maOrder;

    public Order(Integer accountID, String companyName, String address, String city, String phone, Integer maOrder) {
        this.accountID = accountID;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.maOrder = maOrder;
    }

    public Order() {
        
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
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

    public Integer getOrder() {
        return maOrder;
    }

    public void setOrder(Integer maOrder) {
        this.maOrder = maOrder;
    }

    
}
