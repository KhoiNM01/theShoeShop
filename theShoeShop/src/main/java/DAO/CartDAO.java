package DAO;

import Database.DBContext;
import Model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private Connection connection;

    public CartDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    public void addToCart(String accountId, String productId, Integer quantity, Float subtotal) {
        try {
            String query = "INSERT INTO cart (account_id, product_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, accountId);
            preparedStatement.setString(2, productId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setFloat(4, subtotal);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cart> getAllItemsInCart(String accountId) {
        List<Cart> cartItems = new ArrayList<>();
        try {
            String query = "SELECT * FROM cart WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productId = resultSet.getString("product_id");
                Integer quantity = resultSet.getInt("quantity");
                Float subtotal = resultSet.getFloat("subtotal");
                Cart cartItem = new Cart(accountId, productId, quantity, subtotal);
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public void updateCartItemQuantity(String accountId, String productId, Integer newQuantity, Float newSubtotal) {
        try {
            String query = "UPDATE cart SET quantity = ?, subtotal = ? WHERE account_id = ? AND product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setFloat(2, newSubtotal);
            preparedStatement.setString(3, accountId);
            preparedStatement.setString(4, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFromCart(String accountId, String productId) {
        try {
            String query = "DELETE FROM cart WHERE account_id = ? AND product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, accountId);
            preparedStatement.setString(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
