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

@WebServlet("/panelGroups")
public class ServletEditGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        String name = request.getParameter("name");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Group addGroup = new Group(name);
        Group editGroup = new Group(id, name);
        switch (option) {
            case "add":
                groupDao.create(addGroup);
                break;
            case "edit":
                groupDao.update(editGroup);
            default:
                response.getWriter().println("Nie można zaktualizować grup.");
        }
        List<Group> groups = groupDao.allGroups();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/panelGroups.jsp").forward(request, response);
    }

    GroupDao groupDao = new GroupDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = groupDao.allGroups();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/panelGroups.jsp").forward(request, response);
    }
}
