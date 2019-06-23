package pl.codreslab.controller;

import pl.codreslab.model.User;
import pl.codreslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelUsers")
public class ServletEditUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        String username = request.getParameter("username");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer userGroupId = Integer.parseInt(request.getParameter("userGroupId"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User addUser = new User(username,email,password, userGroupId);
        User editUser = new User(id,username,email,password,userGroupId);
        switch (option) {
            case "add":
                userDao.create(addUser);
                break;
            case "edit":
                userDao.update(editUser);
            default:
                response.getWriter().println("Nie można zaktualizować użytkowników.");
        }
        List<User> users = userDao.allUsers();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/panelUsers.jsp").forward(request, response);
    }

    UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDao.allUsers();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/panelUsers.jsp").forward(request, response);
    }
}
