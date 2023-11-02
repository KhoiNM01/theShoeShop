package Model;

import java.sql.Date;

public class Invoice {
    private int maInvoice;
    private int accountID;
    private float Total;
    private Date date;

    public Invoice(int maInvoice, int accountID, float Total, Date date) {
        this.maInvoice = maInvoice;
        this.accountID = accountID;
        this.Total = Total;
        this.date = date;
    }

    public Invoice() {
        
    }

    public int getMaInvoice() {
        return maInvoice;
    }

    public void setMaInvoice(int maInvoice) {
        this.maInvoice = maInvoice;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public Date getInvoiceDate() {
        return date;
    }

    public void setInvoiceDate(Date date) {
        this.date = date;
    }
}
