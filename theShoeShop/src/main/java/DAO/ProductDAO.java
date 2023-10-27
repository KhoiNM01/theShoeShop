package DAO;

import Database.DBContext;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final Connection connection;

    public ProductDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve all products from the database
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setImage(resultSet.getString("image"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryID(resultSet.getInt("cateID"));
                product.setSell_ID(resultSet.getInt("sell_ID"));
                product.setImage2(resultSet.getString("image2"));
                product.setImage3(resultSet.getString("image3"));
                product.setImage4(resultSet.getString("image4"));
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> getProductsByIdOrName(String keyword) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE id = ? OR title LIKE ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Setting parameters for ID and name search
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, "%" + keyword + "%");

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setImage(resultSet.getString("image"));
                    product.setTitle(resultSet.getString("title"));
                    product.setDescription(resultSet.getString("description"));
                    product.setCategoryID(resultSet.getInt("cateID"));
                    product.setSell_ID(resultSet.getInt("sell_ID"));
                    product.setImage2(resultSet.getString("image2"));
                    product.setImage3(resultSet.getString("image3"));
                    product.setImage4(resultSet.getString("image4"));
                    products.add(product);
                }
            }
        }
        return products;
    }

    // Method to add a new product to the database
    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (image, title, description, cateID, sell_ID, image2, image3, image4) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getImage());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getCategoryID());
            preparedStatement.setInt(5, product.getSell_ID());
            preparedStatement.setString(6, product.getImage2());
            preparedStatement.setString(7, product.getImage3());
            preparedStatement.setString(8, product.getImage4());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing product in the database
    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE Product SET image=?, title=?, description=?, cateID=?, sell_ID=?, image2=?, image3=?, image4=? WHERE id=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getImage());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getCategoryID());
            preparedStatement.setInt(5, product.getSell_ID());
            preparedStatement.setString(6, product.getImage2());
            preparedStatement.setString(7, product.getImage3());
            preparedStatement.setString(8, product.getImage4());
            preparedStatement.setInt(9, product.getId());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete a product from the database by ID
    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Product WHERE id=?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        }
    }
}
