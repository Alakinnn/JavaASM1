package Utils;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Provides utility methods for parsing date strings into LocalDate objects.
 *
 * <p>
 * This class contains a static method {@code parseDate} that attempts to parse a given date string
 * using various date patterns. It supports both hyphenated and non-hyphenated date formats.
 * </p>
 *
 * <p>
 * Note: This class is not intended to be instantiated.
 * </p>
 */
public class DateFormatter {

    /**
     * Parses a date string into a LocalDate object using various date patterns.
     *
     * @param dateString The date string to parse.
     * @return The LocalDate object representing the parsed date, or null if parsing fails.
     */
    public static LocalDate parseDate(String dateString) {
        // Define supported date patterns
        String[] patterns = {
                "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd",  // With hyphens
                "ddMMyyyy", "MMddyyyy", "yyyyMMdd"         // Without hyphens
        };

        // Try each pattern until successful parsing or all patterns are exhausted
        for (String pattern : patterns) {
            try {
                return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException ignored) {
                // Ignore exception and try the next pattern
            }
        }

        // Return null if parsing fails for all patterns
        return null;
    }
}
