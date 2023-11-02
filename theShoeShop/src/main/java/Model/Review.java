package Model;

import java.sql.Date;

public class Review {
    private int accountID;
    private int productsID;
    private String contentReview;
    private Date dateReview;
    private int maReview;

    public Review(int accountID, int productsID, String contentReview, Date dateReview, int maReview) {
        this.accountID = accountID;
        this.productsID = productsID;
        this.contentReview = contentReview;
        this.dateReview = dateReview;
        this.maReview = maReview;
    }

    public Review() {
        
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productsID;
    }

    public void setProductID(int productsID) {
        this.productsID = productsID;
    }

    public String getReviewContent() {
        return contentReview;
    }

    public void setReviewContent(String contentReview) {
        this.contentReview = contentReview;
    }

    public Date getReviewDate() {
        return dateReview;
    }

    public void setReviewDate(Date dateReview) {
        this.dateReview = dateReview;
    }

    public int getMaReview() {
        return maReview;
    }

    public void setMaReview(int maReview) {
        this.maReview = maReview;
    }
}