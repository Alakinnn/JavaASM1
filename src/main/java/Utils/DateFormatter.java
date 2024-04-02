package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    public static LocalDate parseDate(String dateString) {
        String[] patterns = {
                "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd",  // With hyphens
                "ddMMyyyy", "MMddyyyy", "yyyyMMdd"         // Without hyphens
        };
        for (String pattern : patterns) {
            try {
                return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }
}
