package pl.codreslab.controller;

import pl.codreslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/group")
public class ServletGroupMembers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Integer grId = Integer.parseInt(request.getParameter("grId"));
        List<User> users = user.findAllByGroupId(grId);
        request.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/WEB-INF/group.jsp").forward(request,response);
    }
}
