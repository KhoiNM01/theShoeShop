package Model;

import java.sql.Date;

public class Review {

    private String id;
    private String productID;
    private String customerName;
    private Integer rating;
    private String comment;
    private Date date;


    public Review(String id, String productID, String customerName, Integer rating, String comment, Date date) {
        this.id = id;
        this.productID = productID;
        this.customerName = customerName;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewID() {
        return id;
    }

    public void setReviewID(String id) {
        this.id = id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}