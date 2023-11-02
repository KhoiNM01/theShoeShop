package DAO;

import Database.DBContext;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private final Connection connection;

    public OrderDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve all orders from the database
    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Order";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setAccountID(resultSet.getInt("accountID"));
                    order.setCompanyName(resultSet.getString("companyName"));
                    order.setAddress(resultSet.getString("address"));
                    order.setCity(resultSet.getString("city"));
                    order.setPhone(resultSet.getString("phone"));
                    order.setMaOrder(resultSet.getInt("maOrder"));
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    // Method to retrieve all orders from the database for a specific account ID
    public List<Order> getOrdersByAccountId(int accountId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Order WHERE accountId=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setAccountID(resultSet.getInt("accountID"));
                    order.setCompanyName(resultSet.getString("companyName"));
                    order.setAddress(resultSet.getString("address"));
                    order.setCity(resultSet.getString("city"));
                    order.setPhone(resultSet.getString("phone"));
                    order.setMaOrder(resultSet.getInt("maOrder"));
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    // Method to add a new order to the database
    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO Order (accountId, companyName, address, city, phone, maOrder) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getAccountID());
            preparedStatement.setString(2, order.getCompanyName());
            preparedStatement.setString(3, order.getAddress());
            preparedStatement.setString(4, order.getCity());
            preparedStatement.setString(5, order.getPhone());
            preparedStatement.setInt(6, order.getMaOrder());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing order in the database
    public void updateOrder(Order order) throws SQLException {
        String query = "UPDATE Order SET accountId=?, companyName=?, address=?, city=?, phone=? WHERE maOrder=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getAccountID());
            preparedStatement.setString(2, order.getCompanyName());
            preparedStatement.setString(3, order.getAddress());
            preparedStatement.setString(4, order.getCity());
            preparedStatement.setString(5, order.getPhone());
            preparedStatement.setInt(6, order.getMaOrder());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete an order from the database by order ID
    public void deleteOrder(int orderId) throws SQLException {
        String query = "DELETE FROM Order WHERE maOrder=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        }
    }
}
