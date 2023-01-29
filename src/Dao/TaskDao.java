package Dao;

import Model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    static List<Task> tasks = new ArrayList<>();

    public static List<Task> getTasks() {
        System.out.println(tasks);
        return tasks;
    }

    public static void addTask(Task task) {
        tasks.add(task);
        addTaskToDatabase(task);
    }

    private static void addTaskToDatabase(Task task) {
        String query = "INSERT INTO TASK (NAME, DESCRIPTION, DEADLINE, PRIORITY) " +
                "VALUES ('" + task.getName() + "', '" + task.getDescription() + "', '" +
               task.getDeadline() + "', " + task.getPriority().toString() + ");";
        try(
                Connection connection = DriverManager.getConnection(Connect.DATABASE_URL, Connect.USER, Connect.PASSWORD);
                Statement statement = connection.createStatement()
        ) {
                int rowCount = statement.executeUpdate(query);
            System.out.println("Zapisanych rekordów w bazie: " + rowCount);
        } catch (SQLException e) {
            System.out.println("Bład połączenia z bazą danych");
        }
    }

    public static void updateTask(Task task) {
        String query = "UPDATE TASK SET " +
                "DESCRIPTION = '" + task.getDescription() + "', DEADLINE = '" + task.getDeadline() + "', PRIORITY = " +
                task.getPriority().toString() + " WHERE NAME = '" + task.getName() + "';";

        try(
                Connection connection = DriverManager.getConnection(Connect.DATABASE_URL, Connect.USER, Connect.PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            int rowCount = statement.executeUpdate(query);
            System.out.println("Zmodyfikowanych rekordów w bazie: " + rowCount);
        } catch (SQLException e) {
            System.out.println("Bład połączenia z bazą danych");
        }
    }

    public static void deleteTask(String name) {

    }
}
