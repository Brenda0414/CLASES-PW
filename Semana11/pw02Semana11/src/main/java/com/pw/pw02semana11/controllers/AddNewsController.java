/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw02semana11.controllers;

import com.pw.pw02semana11.dao.CategoryDAO;
import com.pw.pw02semana11.dao.NewsDAO;
import com.pw.pw02semana11.models.Category;
import com.pw.pw02semana11.models.News;
import com.pw.pw02semana11.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author magoc
 */
@WebServlet(name = "AddNewsController", urlPatterns = {"/AddNewsController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class AddNewsController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = CategoryDAO.getCategories();
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("newsForm.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("category"), 10);
        Part file = request.getPart("image");

        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        
        News newNews = new News(title, description, FileUtils.RUTE_USER_IMAGE + "/" + nameImage, new Category(idCategory));
        NewsDAO.insertNews(newNews);
        
        List<Category> categories = CategoryDAO.getCategories();
        List<News> news = NewsDAO.getNews();
        request.setAttribute("Categories", categories);
        request.setAttribute("News", news);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
