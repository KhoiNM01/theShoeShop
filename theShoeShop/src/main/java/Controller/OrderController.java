/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Order;
import DAO.OrderDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    public void init() throws ServletException {
        super.init();
        try {
            orderDAO = new OrderDAO();
        } catch (SQLException e) {
            throw new ServletException("Error initializing OrderDAO: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "list":
                    listOrders(request, response);
                    break;
                case "showForm":
                    showOrderForm(request, response);
                    break;
                case "addOrder":
                    addOrder(request, response);
                    break;
                case "updateOrder":
                    updateOrder(request, response);
                    break;
                case "deleteOrder":
                    deleteOrder(request, response);
                    break;
                default:
                    listOrders(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Order> orders = orderDAO.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("list-orders.jsp").forward(request, response);
    }

    private void showOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement this method to show a form for adding or updating an order
        // You can forward to a JSP form for adding/updating an order
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve data from the request parameters
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        String companyName = request.getParameter("companyName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        int maOrder = Integer.parseInt(request.getParameter("maOrder"));

        // Create an Order object
        Order order = new Order();
        order.setAccountID(accountId);
        order.setCompanyName(companyName);
        order.setAddress(address);
        order.setCity(city);
        order.setPhone(phone);
        order.setMaOrder(maOrder);

        // Call orderDAO.addOrder(order) to add the order to the database
        orderDAO.addOrder(order);

        // Redirect back to the list of orders after adding
        response.sendRedirect("order?action=list");
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve data from the request parameters
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        String companyName = request.getParameter("companyName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        int maOrder = Integer.parseInt(request.getParameter("maOrder"));

        // Create an Order object
        Order order = new Order();
        order.setAccountID(accountId);
        order.setCompanyName(companyName);
        order.setAddress(address);
        order.setCity(city);
        order.setPhone(phone);
        order.setMaOrder(maOrder);

        // Call orderDAO.updateOrder(order) to update the order in the database
        orderDAO.updateOrder(order);

        // Redirect back to the list of orders after updating
        response.sendRedirect("order?action=list");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve the orderId from the request parameters
        int maOrder = Integer.parseInt(request.getParameter("maOrder"));

        // Call orderDAO.deleteOrder(orderId) to delete the order from the database
        orderDAO.deleteOrder(maOrder);

        // Redirect back to the list of orders after deleting
        response.sendRedirect("order?action=list");
    }
}
