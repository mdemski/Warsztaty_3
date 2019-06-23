package pl.codreslab.controller;

import pl.codreslab.model.Solution;
import pl.codreslab.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")
public class ServletDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        Integer solutionId = Integer.parseInt(request.getParameter("solId"));
        Solution solution = solutionDao.read(solutionId);
        request.setAttribute("solution",solution);
        System.out.println(solution);
        getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request,response);
    }
}
