package Dao;

import Model.Task;
import Utils.AuxiliaryMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    static List<Task> tasks;

    public static void loadTasksFromDatabase() {
        String query = "SELECT * FROM TASK;";
        try (
                Connection connection = DriverManager.getConnection(Connect.DATABASE_URL, Connect.USER, Connect.PASSWORD);
                Statement statement = connection.createStatement()
                ) {
                    try (
                            ResultSet resultSet = statement.executeQuery(query)
                            ) {
                        tasks = AuxiliaryMethods.mapToTasks(resultSet);
                    }
        } catch (SQLException e) {
            System.out.println("Bład połączenia z bazą danych");
        }
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
        for (Task taskFromList : tasks) {
            if(taskFromList.getName().equals(task.getName())) {
                taskFromList.setDescription(task.getDescription());
                taskFromList.setDeadline(task.getDeadline());
                taskFromList.setPriority(task.getPriority());
                updateTaskInDatabase(task);
                return;
            }
        }
        System.out.println("Nie odnaleziono zadania o podanej nazwie.");
    }

    private static void updateTaskInDatabase(Task task) {
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
        for (Task task : tasks) {
            if(task.getName().equals(name)) {
                tasks.remove(task);
                deleteTaskFromDatabase(name);
                return;
            }
        }
        System.out.println("Nie odnaleziono zadania o podanej nazwie.");
    }

    private static void deleteTaskFromDatabase(String name) {
        String query = "DELETE FROM TASK WHERE NAME = '" + name + "';" ;
        try(
                Connection connection = DriverManager.getConnection(Connect.DATABASE_URL, Connect.USER, Connect.PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            int rowCount = statement.executeUpdate(query);
            System.out.println("Usuniętych rekordów z bazy: " + rowCount);
        } catch (SQLException e) {
            System.out.println("Bład połączenia z bazą danych");
        }
    }

    public static void getSelectedTask(String name) {
        for (Task task : tasks) {
            if(task.getName().equals(name)) {
                System.out.println(task);
                return;
            } 
        }
        System.out.println("Nie odnaleziono zadania o podanej nazwie.");
    }
    public static void getAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public static void getSortedTasks(String sortedBy, String order) {
        List<Task> sortedTasks = new ArrayList<>();
        String query = "SELECT * FROM TASK ORDER BY " + sortedBy + " " + order + ";";
        try (
                Connection connection = DriverManager.getConnection(Connect.DATABASE_URL, Connect.USER, Connect.PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            try (
                    ResultSet resultSet = statement.executeQuery(query)
            ) {
                sortedTasks = AuxiliaryMethods.mapToTasks(resultSet);
                for (Task sortedTask : sortedTasks) {
                    System.out.println(sortedTask);
                }
            }
        } catch (SQLException e) {
            System.out.println("Bład połączenia z bazą danych");
        }
    }
    }

