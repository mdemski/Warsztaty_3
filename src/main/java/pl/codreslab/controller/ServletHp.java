package pl.codreslab.controller;

import pl.codreslab.model.Solution;
import pl.codreslab.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ServletHp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        Integer number = Integer.parseInt(getContextParameter("numbersolutions"));
        List<Solution> solutions = solutionDao.findRecent(number);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected String getContextParameter(String name) {
        return getServletContext().getInitParameter(name);
    }
}
