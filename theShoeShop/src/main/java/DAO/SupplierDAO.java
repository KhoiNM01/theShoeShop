package DAO;

import Database.DBContext;
import Model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    private final Connection connection;

    public SupplierDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve all suppliers from the database
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM Supplier";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierID(resultSet.getInt("idSupplier"));
                supplier.setSupplierName(resultSet.getString("nameSupplier"));
                supplier.setSupplierPhone(resultSet.getString("phoneSupplier"));
                supplier.setSupplierEmail(resultSet.getString("emailSupplier"));
                supplier.setSupplierAddress(resultSet.getString("addressSupplier"));
                supplier.setCategoryID(resultSet.getInt("cateID"));
                suppliers.add(supplier);
            }
        }
        return suppliers;
    }

    // Method to add a new supplier to the database
    public void addSupplier(Supplier supplier) throws SQLException {
        String query = "INSERT INTO Supplier (nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getSupplierPhone());
            preparedStatement.setString(3, supplier.getSupplierEmail());
            preparedStatement.setString(4, supplier.getSupplierAddress());
            preparedStatement.setInt(5, supplier.getCategoryID());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing supplier in the database
    public void updateSupplier(Supplier supplier) throws SQLException {
        String query = "UPDATE Supplier SET nameSupplier=?, phoneSupplier=?, emailSupplier=?, addressSupplier=?, cateID=? WHERE idSupplier=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getSupplierPhone());
            preparedStatement.setString(3, supplier.getSupplierEmail());
            preparedStatement.setString(4, supplier.getSupplierAddress());
            preparedStatement.setInt(5, supplier.getCategoryID());
            preparedStatement.setInt(6, supplier.getSupplierID());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete a supplier from the database by ID
    public void deleteSupplier(int idSupplier) throws SQLException {
        String query = "DELETE FROM Supplier WHERE idSupplier=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idSupplier);
            preparedStatement.executeUpdate();
        }
    }
}

