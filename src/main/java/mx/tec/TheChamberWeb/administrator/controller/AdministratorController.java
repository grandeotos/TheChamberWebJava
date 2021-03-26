package mx.tec.TheChamberWeb.administrator.controller;

import mx.tec.TheChamberWeb.administrator.dao.AdministratorDao;
import mx.tec.TheChamberWeb.administrator.model.Administrator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AuthController", value = "/auth")
public class AdministratorController extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdministratorDao administratorDao = new AdministratorDao();
        Administrator cuenta = administratorDao.auth(username, password);

        try{
            if(cuenta == null){
                request.getRequestDispatcher("index.html").forward(request, response);
            }else{
                request.getRequestDispatcher("AdminPanel.html").forward(request, response);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}