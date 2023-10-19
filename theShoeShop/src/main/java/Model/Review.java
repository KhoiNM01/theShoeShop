package Model;

import java.sql.Date;

public class Review {

    private String id;
    private String productId;
    private String customerName;
    private Integer rating;
    private String comment;
    private Date date;


    public Review(String id, String productId, String customerName, Integer rating, String comment, Date date) {
        this.id = id;
        this.productId = productId;
        this.customerName = customerName;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewId() {
        return id;
    }

    public void setReviewId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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