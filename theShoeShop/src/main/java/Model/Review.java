package Model;

import java.sql.Date;

public class Review {
    private Integer accountID;
    private Integer productsID;
    private String contentReview;
    private Date dateReview;
    private Integer maReview;

    public Review(Integer accountID, Integer productsID, String contentReview, Date dateReview, Integer maReview) {
        this.accountID = accountID;
        this.productsID = productsID;
        this.contentReview = contentReview;
        this.dateReview = dateReview;
        this.maReview = maReview;
    }

    public Review() {
        
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getProductID() {
        return productsID;
    }

    public void setProductID(Integer productsID) {
        this.productsID = productsID;
    }

    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    public Date getDateReview() {
        return dateReview;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    public Integer getReview() {
        return maReview;
    }

    public void setReview(Integer maReview) {
        this.maReview = maReview;
    }
}