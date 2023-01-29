import Dao.TaskDao;
import Input.UserInputCommand;
import Model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main.run();
    }
    private static void run() {
        TaskDao.loadTasksFromDatabase();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź komendę (EXIT aby wyjść): ");
        String line = scanner.nextLine();
        while (!line.contains("EXIT")) {
            UserInputCommand command = new UserInputCommand(line);
            command.getCommandFromLine();
            line = scanner.nextLine();
        }
    }
}