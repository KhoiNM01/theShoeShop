package Controller;

import Model.Account;
import DAO.AccountDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;

    public void init() {
        try {
            accountDAO = new AccountDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                action = "list";
            }

            switch (action) {
                case "list":
                    listAccounts(request, response);
                    break;
                case "showForm":
                    showAccountForm(request, response);
                    break;
//                case "add":
//                    addAccount(request, response);
//                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateAccount(request, response);
                    break;
                case "delete":
                    deleteAccount(request, response);
                    break;
                default:
                    listAccounts(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAccounts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Account> accounts = accountDAO.getAllAccounts();
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("account-list.jsp").forward(request, response);
    }

    private void showAccountForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("account-form.jsp").forward(request, response);
    }

//    private void addAccount(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String fullName = request.getParameter("fullName");
//        String email = request.getParameter("email");
//
//        Account newAccount = new Account(username, password, fullName, false, email);
//        accountDAO.addAccount(newAccount);
//        response.sendRedirect("account?action=list");
//    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        Account existingAccount = accountDAO.getAccountById(userId);
        request.setAttribute("account", existingAccount);
        request.getRequestDispatcher("account-form.jsp").forward(request, response);
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

        Account account = new Account(userId, username, password, fullName, isAdmin, email);
        accountDAO.updateAccountWithRole(account);
        response.sendRedirect("account?action=list");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        accountDAO.deleteAccount(userId);
        response.sendRedirect("account?action=list");
    }
}
