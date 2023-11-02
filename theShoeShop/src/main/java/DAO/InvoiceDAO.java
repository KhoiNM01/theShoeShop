package DAO;

import Database.DBContext;
import Model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private final Connection connection;

    public InvoiceDAO() throws SQLException {
        this.connection = DBContext.getConnection();
    }

    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM Invoice";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setMaInvoice(resultSet.getInt("maInvoice"));
                invoice.setAccountID(resultSet.getInt("accountID"));
                invoice.setTotal(resultSet.getFloat("total"));
                invoice.setInvoiceDate(resultSet.getDate("date"));
                invoices.add(invoice);
            }
        }
        return invoices;
    }

    public void addInvoice(Invoice invoice) throws SQLException {
        String query = "INSERT INTO Invoice (accountID, total, date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, invoice.getAccountID());
            preparedStatement.setFloat(2, invoice.getTotal());
            preparedStatement.setDate(3, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            preparedStatement.executeUpdate();
        }
    }

    public void updateInvoice(Invoice invoice) throws SQLException {
        String query = "UPDATE Invoice SET accountID=?, total=?, date=? WHERE maInvoice=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, invoice.getAccountID());
            preparedStatement.setFloat(2, invoice.getTotal());
            preparedStatement.setDate(3, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            preparedStatement.setInt(4, invoice.getMaInvoice());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteInvoice(int maInvoice) throws SQLException {
        String query = "DELETE FROM Invoice WHERE maInvoice=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maInvoice);
            preparedStatement.executeUpdate();
        }
    }
}

