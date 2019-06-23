package pl.codreslab.controller;

import pl.codreslab.model.Exercise;
import pl.codreslab.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelExercises")
public class ServletEditExercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        String title = request.getParameter("title");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");

        Exercise addExercise = new Exercise(title,description);
        Exercise editExercise = new Exercise(id,title,description);
        switch (option) {
            case "add":
                exerciseDao.create(addExercise);
                break;
            case "edit":
                exerciseDao.update(editExercise);
            default:
                response.getWriter().println("Nie można zaktualizować zadań.");
        }
        List<Exercise> exercises = exerciseDao.allExercises();
        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/panelExercises.jsp").forward(request, response);
    }

    ExerciseDao exerciseDao = new ExerciseDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exercise> exercises = exerciseDao.allExercises();
        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/panelExercises.jsp").forward(request, response);
    }
}
