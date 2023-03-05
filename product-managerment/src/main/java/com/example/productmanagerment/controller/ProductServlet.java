package com.example.productmanagerment.controller;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.service.IplProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IplProduct product = new IplProduct();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = product.listProduct();
        request.setAttribute("list", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product1 = product.listProduct().get(id);
        if (product1 == null){
            request.getRequestDispatcher("error404.jsp");
        }else {
            request.setAttribute("product", product1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/view.jsp");
            dispatcher.forward(request,response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product1 = product.listProduct().get(id);
        RequestDispatcher dispatcher;
        if (product1 == null){
            dispatcher = request.getRequestDispatcher("error404.jsp");
        }else {
            request.setAttribute("product", product1);
            dispatcher = request.getRequestDispatcher("product/deleteProduct.jsp");
        }
        dispatcher.forward(request,response);

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product1 = product.listProduct().get(id);
        RequestDispatcher dispatcher;
        if (product1==null){
            dispatcher = request.getRequestDispatcher("error404.jsp");
        }else {
            request.setAttribute("product",product1);
            dispatcher = request.getRequestDispatcher("product/editProduct.jsp");
            dispatcher.forward(request,response);
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProducts(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product1 = product.listProduct().get(id);
        RequestDispatcher dispatcher;
        if (product1 == null){
            dispatcher = request.getRequestDispatcher("error404.jsp");
        }else {
            product.remove(id);
            response.sendRedirect("/products");
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String idProduct = request.getParameter("idProduct");
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String note = request.getParameter("note");
        Product product1 = product.listProduct().get(id);
        RequestDispatcher dispatcher;
        if(product1 == null){
            dispatcher = request.getRequestDispatcher("error404.jsp");
        } else {
            product1.setIdProduct(idProduct);
            product1.setName(name);
            product1.setPrice(price);
            product1.setProducer(producer);
            product1.setNote(note);
            product.update(id,product1);
            request.setAttribute("product", product1);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("product/editProduct.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        int id = (int) (Math.random() * 1000);
        String idProduct = request.getParameter("idProduct");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String note = request.getParameter("note");
        Product product1 = new Product(id,idProduct,name,price,producer,note);
        product.create(product1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
