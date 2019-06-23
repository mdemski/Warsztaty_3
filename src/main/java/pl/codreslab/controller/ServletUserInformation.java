package pl.codreslab.controller;

import pl.codreslab.model.Solution;
import pl.codreslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class ServletUserInformation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        Solution solution = new Solution();
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        List<Solution> solutionList = solution.findAllByUserId(userId);
        request.setAttribute("user",userDao.read(userId));
        request.setAttribute("usersSolutions", solutionList);
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request,response);
    }
}
