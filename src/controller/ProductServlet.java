package controller;

import model.Product;
import service.IProduct;
import service.ProductImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/system")
public class ProductServlet extends HttpServlet {
    private IProduct product = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    CreateNewProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                DeleteProduct(request,response);
                break;
            case "update":
                try {
                    UpdateProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                showHome(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("nameSearch");
        List<Product> product = this.product.findProductByName(name);

        request.setAttribute("products",product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float Price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Product product = new Product(id, name,Price,amount,color,description,category);

        request.setAttribute("products",product);

        this.product.update(id,product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            this.product.remove(id);
            response.sendRedirect("/system?action=home.jsp");
        }catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void CreateNewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        float Price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        
        Product products = new Product(name,Price,amount,color,description,category);
        this.product.save(products);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "update":
                try {
                    showUpdateForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                showHome(request,response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = this.product.findByID(id);

        request.setAttribute("products",product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = this.product.findByID(id);
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.product.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
