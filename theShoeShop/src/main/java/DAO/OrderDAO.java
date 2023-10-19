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
    private Connection connection;

    public OrderDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO orders (id, account_id, date, total, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, order.getOrderId());
            preparedStatement.setString(2, order.getAccountId());
            preparedStatement.setDate(3, new java.sql.Date(order.getDate().getTime()));
            preparedStatement.setFloat(4, order.getTotal());
            preparedStatement.setString(5, order.getStatus());
            preparedStatement.executeUpdate();
        }
    }
    
    public Order getOrderById(String orderId) throws SQLException {
        Order order = null;
        String query = "SELECT * FROM orders WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    order = new Order();
                    order.setOrderId(resultSet.getString("id"));
                    order.setAccountId(resultSet.getString("account_id"));
                    order.setDate(resultSet.getDate("date"));
                    order.setTotal(resultSet.getFloat("total"));
                    order.setStatus(resultSet.getString("status"));
                }
            }
        }
        return order;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getString("id"));
                order.setAccountId(resultSet.getString("account_id"));
                order.setDate(resultSet.getDate("date"));
                order.setTotal(resultSet.getFloat("total"));
                order.setStatus(resultSet.getString("status"));
                orders.add(order);
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException {
        String query = "UPDATE orders SET account_id=?, date=?, total=?, status=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, order.getAccountId());
            preparedStatement.setDate(2, new java.sql.Date(order.getDate().getTime()));
            preparedStatement.setFloat(3, order.getTotal());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.setString(5, order.getOrderId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteOrder(String orderId) throws SQLException {
        String query = "DELETE FROM orders WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
        }
    }
}
