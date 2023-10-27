package DAO;

import Database.DBContext;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private final Connection connection;

    public AccountDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    // Method to retrieve all accounts from the database
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account();
                account.setUserId(resultSet.getInt("userId"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setFullName(resultSet.getString("fullName"));
                account.setAdmin(resultSet.getBoolean("isAdmin"));
                account.setEmail(resultSet.getString("email"));
                accounts.add(account);
            }
        }
        return accounts;
    }
    
    // Method to add a new account to the database
    public void addAccount(Account account) throws SQLException {
        String query = "INSERT INTO Account (username, password, fullName, isAdmin, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getFullName());
            preparedStatement.setBoolean(4, account.isAdmin());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    // Method to update an existing account in the database
    public void updateAccount(Account account) throws SQLException {
        String query = "UPDATE Account SET username=?, password=?, fullName=?, isAdmin=?, email=? WHERE userId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getFullName());
            preparedStatement.setBoolean(4, account.isAdmin());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setInt(6, account.getUserId());
            preparedStatement.executeUpdate();
        }
    }

    // Method to delete an account from the database by user ID
    public void deleteAccount(int userId) throws SQLException {
        String query = "DELETE FROM Account WHERE userId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }
    }
}
