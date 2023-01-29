package Utils;

import Model.Task;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AuxiliaryMethods {

    public static LocalDateTime getDateTime(String text) {
        LocalDateTime dateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        return dateTime;
    }

    public static List<Task> mapToTasks(ResultSet resultSet) {
        List<Task> tasks = new ArrayList<>();
        try {
            while(resultSet.next()) {
                //Integer id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");
                LocalDateTime dateTime = resultSet.getTimestamp("DEADLINE").toLocalDateTime();
                Integer priority = resultSet.getInt("PRIORITY");
                tasks.add(new Task(name, description, dateTime, priority));
            }
        } catch (SQLException e) {
            System.out.println("Błąd w trakcie mapowania obiektów");
        }
        return tasks;
    }
}
