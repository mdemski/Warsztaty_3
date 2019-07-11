package pl.codreslab.dao;


import pl.codreslab.db.DbUtil;
import pl.codreslab.model.Exercise;
import pl.codreslab.model.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseDao {
    private static final String CREATE_EXERCISE_QUERY =
            "INSERT INTO exercise(title, description) VALUES (?, ?)";
    private static final String READ_EXERCISE_QUERY =
            "SELECT * FROM exercise where id = ?";
    private static final String UPDATE_EXERCISE_QUERY =
            "UPDATE exercise SET title = ?, description = ? where id = ?";
    private static final String DELETE_EXERCISE_QUERY =
            "DELETE FROM exercise WHERE id = ?";
    private static final String FIND_ALL_EXERCISE_QUERY =
            "SELECT * FROM exercise";
    private static final String FIND_ALL_EXERCISE_WITH_SOLUTIONS_QUERY = "SELECT * FROM exercise left join solution on exercise.id = solution.exercise_id;";

    public Exercise create(Exercise exercise) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_EXERCISE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                exercise.setId(resultSet.getInt(1));
            }
            return exercise;
        } catch (SQLException e) {
            System.out.println("Nie można utworzyć zadania.");
            return null;
        }
    }

    public Exercise read(int exerId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_EXERCISE_QUERY);
            statement.setInt(1, exerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
                return exercise;
            }
        } catch (SQLException e) {
            System.out.println("Nie można odczytać zadania o id: " + exerId);
        }
        return null;
    }

    public void update(Exercise exercise) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_EXERCISE_QUERY);
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.setInt(3, exercise.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nie można uaktualnić zadania o id: " + exercise.getId());
        }
    }

    public void delete(int exerId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_EXERCISE_QUERY);
            statement.setInt(1, exerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nie można usunąć zadania o id: " + exerId);
        }
    }

    public List<Exercise> allExercises() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_EXERCISE_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Exercise> exerciseList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Exercise exercise = new Exercise(id, title, description);
                exerciseList.add(exercise);
            }
            return exerciseList;
        } catch (SQLException e) {
            System.out.println("Nie odnaleziono zadań.");
        }
        return null;
    }

    public Map<Exercise, Solution> allExercisesWithSolutions() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_EXERCISE_WITH_SOLUTIONS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Map<Exercise, Solution> exerciseList = new HashMap<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int solutionId = resultSet.getInt("solution.id");
                String solutionDescription = resultSet.getString("solution.description");
                int userId = resultSet.getInt("users_id");
                Solution solution = new Solution(solutionId, solutionDescription, userId);
                Exercise exercise = new Exercise(id, title, description);
                exerciseList.put(exercise, solution);
            }
            return exerciseList;
        } catch (SQLException e) {
            System.out.println("Nie odnaleziono zadań.");
        }
        return null;
    }

}
