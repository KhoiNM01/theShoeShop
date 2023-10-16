package Model;

import java.sql.Date;

public class Order {
    private String id;
    private String accountId;
    private Date date;
    private Float total;
    private String status;

    public Order(String id, String accountId, Date date, Float total, String status) {
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public String getOrderId() {
        return id;
    }

    public void setOrderId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
