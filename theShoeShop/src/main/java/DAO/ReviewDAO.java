package DAO;

import Database.DBContext;

import Model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    private Connection connection;

    public ReviewDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }
    

    public void createReview(Review review) {
        String sql = "INSERT INTO reviews (id, productId, customerName, rating, comment, date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, review.getReviewId());
            statement.setString(2, review.getProductId());
            statement.setString(3, review.getCustomerName());
            statement.setInt(4, review.getRating());
            statement.setString(5, review.getComment());
            statement.setDate(6, new java.sql.Date(review.getDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Review getReviewById(String id) {
        Review review = null;
        try {
            String sql = "SELECT * FROM reviews WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                review = extractReviewFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return review;
    }

    public List<Review> getReviewsByProduct(String productId) {
        List<Review> reviews = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reviews WHERE productId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = extractReviewFromResultSet(resultSet);
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void updateReview(Review review) {
        try {
            String sql = "UPDATE reviews SET productId = ?, customerName = ?, rating = ?, comment = ?, date = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, review.getProductId());
            statement.setString(2, review.getCustomerName());
            statement.setInt(3, review.getRating());
            statement.setString(4, review.getComment());
            statement.setDate(5, new java.sql.Date(review.getDate().getTime()));
            statement.setString(6, review.getReviewId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReview(String id) {
        try {
            String sql = "DELETE FROM reviews WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reviews";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Review review = extractReviewFromResultSet(resultSet);
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    private Review extractReviewFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String productId = resultSet.getString("productId");
        String customerName = resultSet.getString("customerName");
        int rating = resultSet.getInt("rating");
        String comment = resultSet.getString("comment");
        Date date = resultSet.getDate("date");
        return new Review(id, productId, customerName, rating, comment, date);
    }
}
