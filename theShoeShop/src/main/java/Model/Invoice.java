package Model;

import java.sql.Date;

public class Invoice {
    private Integer maInvoice;
    private Integer accountID;
    private Float Total;
    private Date date;

    public Invoice(Integer maInvoice, Integer accountID, Float Total, Date date) {
        this.maInvoice = maInvoice;
        this.accountID = accountID;
        this.Total = Total;
        this.date = date;
    }

    public Invoice() {
        
    }

    public Integer getInvoice() {
        return maInvoice;
    }

    public void setInvoice(Integer maInvoice) {
        this.maInvoice = maInvoice;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
