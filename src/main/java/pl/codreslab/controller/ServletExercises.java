package pl.codreslab.controller;

import pl.codreslab.model.Exercise;
import pl.codreslab.dao.ExerciseDao;
import pl.codreslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/exercises")
public class ServletExercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        Map<Exercise, Solution> exercises = exerciseDao.allExercisesWithSolutions();
        Set<Exercise> keys = exercises.keySet();
        request.setAttribute("exercises", keys);
        request.setAttribute("solutions", exercises.values());
        getServletContext().getRequestDispatcher("/WEB-INF/exercises.jsp").forward(request, response);
    }
}
