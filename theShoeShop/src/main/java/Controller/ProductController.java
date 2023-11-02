package Controller;

import DAO.ProductDAO;
import Model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductController extends HttpServlet {

    @WebServlet("/product")
    public class ProductServlet extends HttpServlet {

        private ProductDAO productDAO;

        public void init() throws ServletException {
            try {
                productDAO = new ProductDAO();
            } catch (SQLException e) {
                throw new ServletException("Error initializing ProductDAO: " + e.getMessage());
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");

            if ("list".equals(action)) {
                List<Product> products;
                try {
                    products = productDAO.getAllProducts();
                    request.setAttribute("products", products);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException e) {
                    throw new ServletException("Error getting products: " + e.getMessage());
                }
            } else if ("search".equals(action)) {
                String keyword = request.getParameter("keyword");
                try {
                    List<Product> products = productDAO.searchProductByIdOrName(keyword);
                    request.setAttribute("products", products);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException e) {
                    throw new ServletException("Error searching products: " + e.getMessage());
                }
            } else if ("form".equals(action)) {
                String productIdParam = request.getParameter("productId");
                Product product = new Product();

                if (productIdParam != null && !productIdParam.isEmpty()) {
                    // If productIdParam is not null or empty, it's an edit request
                    int productId = Integer.parseInt(productIdParam);
                    try {
                        // Retrieve the product from the database by its ID
                        List<Product> products = productDAO.getProductById(productId);
                        if (!products.isEmpty()) {
                            product = products.get(0);
                        }
                    } catch (SQLException e) {
                        throw new ServletException("Error retrieving product: " + e.getMessage());
                    }
                }

                // Set the product object as an attribute to be used in the JSP form
                request.setAttribute("product", product);

                // Forward the request to the product form JSP page
                RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
                dispatcher.forward(request, response);
            }

        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");

            if ("add".equals(action)) {
                // Handle the request to add a new product
                String image = request.getParameter("image");
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                int sellId = Integer.parseInt(request.getParameter("sellId"));
                String image2 = request.getParameter("image2");
                String image3 = request.getParameter("image3");
                String image4 = request.getParameter("image4");

                Product newProduct = new Product();
                newProduct.setImage(image);
                newProduct.setTitle(title);
                newProduct.setDescription(description);
                newProduct.setCategoryID(categoryId);
                newProduct.setSellID(sellId);
                newProduct.setImage2(image2);
                newProduct.setImage3(image3);
                newProduct.setImage4(image4);

                try {
                    productDAO.addProduct(newProduct);
                    response.sendRedirect(request.getContextPath() + "/product?action=list");
                } catch (SQLException e) {
                    throw new ServletException("Error adding product: " + e.getMessage());
                }
            } else if ("edit".equals(action)) {
                // Handle the request to edit an existing product
                int productId = Integer.parseInt(request.getParameter("productId"));
                String image = request.getParameter("image");
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                int sellId = Integer.parseInt(request.getParameter("sellId"));
                String image2 = request.getParameter("image2");
                String image3 = request.getParameter("image3");
                String image4 = request.getParameter("image4");

                Product updatedProduct = new Product();
                updatedProduct.setProductID(productId);
                updatedProduct.setImage(image);
                updatedProduct.setTitle(title);
                updatedProduct.setDescription(description);
                updatedProduct.setCategoryID(categoryId);
                updatedProduct.setSellID(sellId);
                updatedProduct.setImage2(image2);
                updatedProduct.setImage3(image3);
                updatedProduct.setImage4(image4);

                try {
                    productDAO.updateProduct(updatedProduct);
                    response.sendRedirect(request.getContextPath() + "/product?action=list");
                } catch (SQLException e) {
                    throw new ServletException("Error updating product: " + e.getMessage());
                }
            } else if ("delete".equals(action)) {
                // Handle the request to delete a product
                int productId = Integer.parseInt(request.getParameter("productId"));

                try {
                    productDAO.deleteProduct(productId);
                    response.sendRedirect(request.getContextPath() + "/product?action=list");
                } catch (SQLException e) {
                    throw new ServletException("Error deleting product: " + e.getMessage());
                }
            }
        }
    }
}
