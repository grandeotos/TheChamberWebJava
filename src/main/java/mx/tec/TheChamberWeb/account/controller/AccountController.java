package mx.tec.TheChamberWeb.account.controller;

import mx.tec.TheChamberWeb.account.dao.AccountDao;
import mx.tec.TheChamberWeb.account.model.Account;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AuthController", value = "/auth")
public class AccountController extends HttpServlet {
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

        AccountDao accountDao = new AccountDao();
        Account cuenta = accountDao.auth(username, password);

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