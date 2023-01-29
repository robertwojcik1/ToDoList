package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuxiliaryMethods {

    public static LocalDateTime getDateTime(String text) {
        LocalDateTime dateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        return dateTime;
    }
}
