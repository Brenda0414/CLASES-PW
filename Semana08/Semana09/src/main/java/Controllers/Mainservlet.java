/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Card;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Stefania Cavazos
 */
@WebServlet(name = "Mainservlet", urlPatterns = {"/Mainservlet"})
public class Mainservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Mainservlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Mainservlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        List<Card> cards = new ArrayList();
        //INFORMACION MOCK
        // INFORMACION DE PRUEBA
        cards.add(new Card("https://cdnb.artstation.com/p/assets/images/images/032/713/319/large/wandah-kurniawan-eocrycrvqaal5eh.jpg?1607264133",
        "Harley Quinn",
                "Hey everyone, here's prototype pics for Harley Quinn from Batman: Arkham City. Sculpted by Pablo Vicentin",
                "https://www.artstation.com/artwork/oA8m1w"));
        
         cards.add(new Card("https://cdna.artstation.com/p/assets/images/images/032/706/626/large/boyu-yang-1.jpg?1607238902",
        "Practice",
                "Model: Komatsu Nana",
                "https://www.artstation.com/artwork/lxL84Y"));
         
          cards.add(new Card("https://cdna.artstation.com/p/assets/images/images/032/689/132/large/dmitry-prozorov-valeera-sanguinar-halloween-version.jpg?1607176931",
        "Valeera Sanguinar (Halloween Version)",
                "World of Warcraft fan art.",
                "https://www.artstation.com/artwork/lxLXlG"));
        request.setAttribute("title", "ForEach");
        request.setAttribute("cards", cards);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
