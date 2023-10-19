package DAO;

import Model.Account;
import Database.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection connection;
    
    public AccountDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    public void addAccount(Account account) throws SQLException {
        String query = "INSERT INTO accounts (id, password, name, gender, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?, ?, Customer)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getCustomerName());
            preparedStatement.setString(4, account.getGender());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setInt(6, account.getPhone());
            preparedStatement.setString(7, account.getAddress());

            preparedStatement.executeUpdate();
        }
    }
    
    
    public Account getAccountById(String accountId) throws SQLException {
        String query = "SELECT * FROM accounts WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountId(resultSet.getString("id"));
                    account.setPassword(resultSet.getString("password"));
                    account.setCustomerName(resultSet.getString("name"));
                    account.setGender(resultSet.getString("gender"));
                    account.setEmail(resultSet.getString("email"));
                    account.setPhone(resultSet.getInt("phone"));
                    account.setAddress(resultSet.getString("address"));
                    account.setRole(resultSet.getString("role"));
                    return account;
                }
            }
        }
        return null;
    }

    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getString("id"));
                account.setPassword(resultSet.getString("password"));
                account.setCustomerName(resultSet.getString("name"));
                account.setGender(resultSet.getString("gender"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getInt("phone"));
                account.setAddress(resultSet.getString("address"));
                account.setRole(resultSet.getString("role"));
                accounts.add(account);
            }
        }
        return accounts;
    }

    public void updateAccount(Account account) throws SQLException {
        String query = "UPDATE accounts SET name=?, password=?, gender=?, email=?, phone=?, address=?, role=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getCustomerName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getGender());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setInt(5, account.getPhone());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setString(7, account.getRole());
            preparedStatement.setString(8, account.getAccountId());

            preparedStatement.executeUpdate();
        }
    }

    public void deleteAccount(String accountId) throws SQLException {
        String query = "DELETE FROM accounts WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, accountId);
            preparedStatement.executeUpdate();
        }
    }
}
