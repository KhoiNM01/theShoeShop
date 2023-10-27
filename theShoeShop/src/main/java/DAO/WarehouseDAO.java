package DAO;

import Database.DBContext;
import Model.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAO {
    private final Connection connection;

    public WarehouseDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    public List<Warehouse> getAllProducts() throws SQLException {
        List<Warehouse> products = new ArrayList<>();
        String query = "SELECT * FROM Warehouse";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Warehouse product = new Warehouse();
                product.setProductID(resultSet.getInt("productsID"));
                product.setProductName(resultSet.getString("nameProduct"));
                product.setImportDate(resultSet.getDate("importDate"));
                product.setSupplierName(resultSet.getString("nameSupplier"));
                product.setBrandName(resultSet.getString("nameBrand"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setSize(resultSet.getInt("size"));
                product.setColor(resultSet.getString("color"));
                product.setPrice(resultSet.getFloat("price"));
                products.add(product);
            }
        }
        return products;
    }

    public void addProduct(Warehouse product) throws SQLException {
        String query = "INSERT INTO Warehouse (nameProduct, importDate, nameSupplier, nameBrand, quantity, size, color, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDate(2, new java.sql.Date(product.getImportDate().getTime()));
            preparedStatement.setString(3, product.getSupplierName());
            preparedStatement.setString(4, product.getBrandName());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getSize());
            preparedStatement.setString(7, product.getColor());
            preparedStatement.setFloat(8, product.getPrice());
            preparedStatement.executeUpdate();
        }
    }

    public void updateProduct(Warehouse product) throws SQLException {
        String query = "UPDATE Warehouse SET nameProduct=?, importDate=?, nameSupplier=?, nameBrand=?, quantity=?, size=?, color=?, price=? WHERE productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDate(2, new java.sql.Date(product.getImportDate().getTime()));
            preparedStatement.setString(3, product.getSupplierName());
            preparedStatement.setString(4, product.getBrandName());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getSize());
            preparedStatement.setString(7, product.getColor());
            preparedStatement.setFloat(8, product.getPrice());
            preparedStatement.setInt(9, product.getProductID());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteProduct(int productsID) throws SQLException {
        String query = "DELETE FROM Warehouse WHERE productsID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productsID);
            preparedStatement.executeUpdate();
        }
    }
}

