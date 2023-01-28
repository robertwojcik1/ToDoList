import Input.UserInputCommand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main.run();
    }
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź komendę (EXIT aby wyjść): ");
        String line = scanner.nextLine();
        while (line != "EXIT") {
            UserInputCommand command = new UserInputCommand(line);
            command.getCommandFromLine();
            line = scanner.nextLine();
        }
    }
}