package DAO;

import Database.DBContext;
import Model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    private final Connection connection;

    public ReviewDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve reviews by product ID from the database
    public List<Review> getReviewsByProductID(int productID) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM Review WHERE productsID=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productID);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Review review = new Review();
                    review.setAccountID(resultSet.getInt("accountID"));
                    review.setProductID(resultSet.getInt("productsID"));
                    review.setContentReview(resultSet.getString("contentReview"));
                    review.setDateReview(resultSet.getDate("dateReview"));
                    review.setReview(resultSet.getInt("maReview"));
                    reviews.add(review);
                }
            }
        }
        return reviews;
    }

    // Method to add a new review to the database
    public void addReview(Review review) throws SQLException {
        String query = "INSERT INTO Review (accountID, productsID, contentReview, dateReview, maReview) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, review.getAccountID());
            preparedStatement.setInt(2, review.getProductID());
            preparedStatement.setString(3, review.getContentReview());
            preparedStatement.setDate(4, new java.sql.Date(review.getDateReview().getTime()));
            preparedStatement.setInt(5, review.getReview());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing review in the database
    public void updateReview(Review review) throws SQLException {
        String query = "UPDATE Review SET contentReview=?, dateReview=?, maReview=? WHERE accountID=? AND productsID=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, review.getContentReview());
            preparedStatement.setDate(2, new java.sql.Date(review.getDateReview().getTime()));
            preparedStatement.setInt(3, review.getReview());
            preparedStatement.setInt(4, review.getAccountID());
            preparedStatement.setInt(5, review.getProductID());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete a review from the database by ID
    public void deleteReview(int accountID, int productsID) throws SQLException {
        String query = "DELETE FROM Review WHERE accountID=? AND productsID=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountID);
            preparedStatement.setInt(2, productsID);
            preparedStatement.executeUpdate();
        }
    }
}
