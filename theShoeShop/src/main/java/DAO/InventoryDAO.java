package DAO;

import Database.DBContext;
import Model.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    private final Connection connection;

   public InventoryDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve all inventory items from the database
    public List<Inventory> getAllInventory() throws SQLException {
        List<Inventory> inventoryList = new ArrayList<>();
        String query = "SELECT * FROM Inventory";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setProductID(resultSet.getInt("productsID"));
                inventory.setQuantitySold(resultSet.getInt("quantitySold"));
                inventory.setInventory(resultSet.getInt("inventory"));
                inventoryList.add(inventory);
            }
        }
        return inventoryList;
    }

    // Method to add a new inventory item to the database
    public void addInventoryItem(Inventory inventoryItem) throws SQLException {
        String query = "INSERT INTO Inventory (productsID, quantitySold, inventory) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, inventoryItem.getProductID());
            preparedStatement.setInt(2, inventoryItem.getQuantitySold());
            preparedStatement.setInt(3, inventoryItem.getInventory());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing inventory item in the database
    public void updateInventoryItem(Inventory inventoryItem) throws SQLException {
        String query = "UPDATE Inventory SET quantitySold=?, inventory=? WHERE productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, inventoryItem.getQuantitySold());
            preparedStatement.setInt(2, inventoryItem.getInventory());
            preparedStatement.setInt(3, inventoryItem.getProductID());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete an inventory item from the database by product ID
    public void deleteInventoryItem(int productsID) throws SQLException {
        String query = "DELETE FROM Inventory WHERE productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productsID);
            preparedStatement.executeUpdate();
        }
    }
}
