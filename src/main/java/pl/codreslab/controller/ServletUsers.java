package pl.codreslab.controller;

import pl.codreslab.model.Solution;
import pl.codreslab.model.User;
import pl.codreslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class ServletUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> users = userDao.allUsers();
        request.setAttribute("users", users);
        for (int i = 0; i < users.size(); i++) {
            Solution solution = new Solution();
            List<Solution> solutionList = solution.findAllByUserId(users.get(i).getId());
            request.setAttribute("usersSolutions", solutionList);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
