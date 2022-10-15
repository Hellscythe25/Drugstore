package wildcat.games.drugstore.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import wildcat.games.drugstore.dao.UserDao;
import wildcat.games.drugstore.model.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adduser.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        int rowsAffected = 0;

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setLastname(request.getParameter("lastname"));
        user.setSex(request.getParameter("sex"));
        user.setAddress(request.getParameter("address"));
        user.setDni(request.getParameter("dni"));
        user.setCellphone(request.getParameter("cellphone"));
        user.setUsername(request.getParameter("username"));
        user.setPass(request.getParameter("pass"));

        try{
            rowsAffected = dao.addUser(user);
            if(rowsAffected>0) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                request.setAttribute("rowsAffected", rowsAffected);
                requestDispatcher.forward(request, response);
            }
        }catch(Exception e){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e );
            requestDispatcher.forward(request,response);
            e.printStackTrace();
        }

    }
}
