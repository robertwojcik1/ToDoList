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
        //Wyświetl na ekranie wpisy pogrupowane względem dnia do kiedy dane zadanie ma zostać
        //zakończone. Podpowiem w tym miejscu, że klauzula GROUP BY wymaga funkcji agregującej aby
        //przedstawić wyniki jako listę, a nie jako np. sumę, czyli count. Jednocześnie trzeba pamiętać, że w
        //bazie mamy zapisane jednocześnie daty i czasy a polecenie prosi nas tylko o datę ὠ Można zatem
        //zrobić to na 2 sposoby:
        //◦ kombinować z funkcjami bazodanowymi, co komplikuje nasze zapytanie, ale w praktyce jak
        //będziemy mieli dużo rekordów, to podejście będzie bardziej wydajne,
        //◦ pobrać wszystkie dane z bazy zwykłym SQL bez grupowania i pogrupować je w kodzie Javovym.
        //W praktyce może być to wolniejsze.
        //Z racji, że w pracy programisty bardzo ważna jest umiejętność googlowania rzeczy, zrobimy to
        //pierwszym sposobem ὠ Przyjmijmy, że komenda, która takie coś zrealizuje to będzie: READ GROUPED;
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