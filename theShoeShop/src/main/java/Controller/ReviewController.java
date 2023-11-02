/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Review;
import DAO.ReviewDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet("/review/*")
public class ReviewController extends HttpServlet {

    private ReviewDAO reviewDAO;

    @Override
    public void init() throws ServletException {
        try {
            super.init();
            reviewDAO = new ReviewDAO();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "addReview":
                    addReview(request, response);
                    break;
                case "updateReview":
                    updateReview(request, response);
                    break;
                case "deleteReview":
                    deleteReview(request, response);
                    break;
            }
        } catch (SQLException | ParseException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
        // Implement the addReview method
    private void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        String reviewContent = request.getParameter("reviewContent");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date reviewDate = (Date) dateFormat.parse(request.getParameter("reviewDate"));
        int maReview = Integer.parseInt(request.getParameter("maReview"));

        Review review = new Review();
        review.setAccountID(accountID);
        review.setProductID(productID);
        review.setReviewContent(reviewContent);
        review.setReviewDate(reviewDate);
        review.setMaReview(maReview);

        reviewDAO.addReview(review);

        // Redirect to a success page or display a message
        response.sendRedirect("home.jsp");
    }


// Implement the updateReview method
    private void updateReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        String reviewContent = request.getParameter("reviewContent");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date reviewDate = (Date) dateFormat.parse(request.getParameter("reviewDate"));
        int maReview = Integer.parseInt(request.getParameter("maReview"));

        Review review = new Review();
        review.setAccountID(accountID);
        review.setProductID(productID);
        review.setReviewContent(reviewContent);
        review.setReviewDate(reviewDate);
        review.setMaReview(maReview);

        reviewDAO.updateReview(review);

        // Redirect to a success page or display a message
        response.sendRedirect("home.jsp");
    }

// Implement the deleteReview method
    private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        int productID = Integer.parseInt(request.getParameter("productID"));

        reviewDAO.deleteReview(accountID, productID);

        // Redirect to a success page or display a message
        response.sendRedirect("home.jsp");
    }
}
