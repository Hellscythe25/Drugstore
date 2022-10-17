package wildcat.games.drugstore.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import wildcat.games.drugstore.dao.UserDao;
import wildcat.games.drugstore.model.User;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/updateuser.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String dni = request.getParameter("dni");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setLastname(request.getParameter("lastname"));
        user.setSex(request.getParameter("sex"));
        user.setAddress(request.getParameter("address"));
        user.setCellphone(request.getParameter("cellphone"));
        user.setUsername(request.getParameter("username"));
        user.setPass(request.getParameter("pass"));
        user.setDni(request.getParameter("dni"));

        try {
            int rowsAffected = dao.updateUser(dni, user);

            if(rowsAffected>0){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                request.setAttribute("rowsAffected", rowsAffected);
                requestDispatcher.forward(request, response);
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                request.setAttribute("message", "El usuario de dni "+ dni + " no existe");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
