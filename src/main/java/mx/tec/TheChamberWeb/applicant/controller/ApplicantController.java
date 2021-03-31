package mx.tec.TheChamberWeb.applicant.controller;


import mx.tec.TheChamberWeb.applicant.dao.ApplicantDao;
import mx.tec.TheChamberWeb.applicant.model.Applicant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicantController", value = "/appReg")
public class ApplicantController extends HttpServlet {
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
        String gamerID = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String curp = request.getParameter("curp");

        if(password.equals(password2)){
            ApplicantDao gamerIdentDao = new ApplicantDao();
            Applicant applicant = gamerIdentDao.register(gamerID, firstName, lastName, password, email, curp);
            System.out.println(applicant);
            try{
                if(applicant == null){
                    request.getRequestDispatcher("index.html").forward(request, response);
                }else{
                    request.getRequestDispatcher("AdminPanel.html").forward(request, response);
                }
            }catch(Exception ex){
                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
            }
        }
        else{
            System.out.println("PASSWORD MISMATCH");
            try{
                response.sendRedirect("index.html");
            } catch (Exception ex){
                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
            }
        }
    }
}