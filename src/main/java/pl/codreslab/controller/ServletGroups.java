package pl.codreslab.controller;

import pl.codreslab.model.Group;
import pl.codreslab.dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class ServletGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        List<Group> groups = groupDao.allGroups();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/groups.jsp").forward(request, response);
    }
}
