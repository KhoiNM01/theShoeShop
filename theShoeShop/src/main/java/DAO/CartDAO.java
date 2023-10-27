package DAO;

import Database.DBContext;
import Model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {
    private final Connection connection;

    public CartDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to add a new item to the cart in the database
    public void addItemToCart(Cart cartItem) throws SQLException {
        String query = "INSERT INTO Cart (accountID, productsID, quantity, maCart) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cartItem.getAccountID());
            preparedStatement.setInt(2, cartItem.getProductID());
            preparedStatement.setInt(3, cartItem.getQuantity());
            preparedStatement.setInt(4, cartItem.getCart());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an item in the cart in the database
    public void updateCartItem(Cart cartItem) throws SQLException {
        String query = "UPDATE Cart SET quantity=? WHERE accountID=? AND productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setInt(2, cartItem.getAccountID());
            preparedStatement.setInt(3, cartItem.getProductID());
            preparedStatement.executeUpdate();
        }
    }

    // Method to remove an item from the cart in the database
    public void removeItemFromCart(int accountID, int productsID) throws SQLException {
        String query = "DELETE FROM Cart WHERE accountID=? AND productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountID);
            preparedStatement.setInt(2, productsID);
            preparedStatement.executeUpdate();
        }
    }
}
