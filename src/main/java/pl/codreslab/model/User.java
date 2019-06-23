package pl.codreslab.model;

import org.mindrot.jbcrypt.BCrypt;
import pl.codreslab.db.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static void main(String[] args) {
        findAllByGroupId(2);
    }
    private int id;
    private String userName;
    private String email;
    private String password;
    private int userGroupId;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.hashPassword(password);
    }

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User(String userName, String email, String password, int userGroupId) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public User(int id, String userName, String email, String password, int userGroupId) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final String USERS_IN_GROUPS = "SELECT users.id, users.username from users where users.group_id = ?";

    public static List<User> findAllByGroupId(int groupId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(USERS_IN_GROUPS);
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int userIds = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                User user = new User(userIds, userName);
                users.add(user);
                System.out.println(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Nie można znaleść użytkowników.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}