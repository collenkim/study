package backend.study.webclient.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getCurrentDateFromPattern(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime getLocalDateTimeFromLong(Long date) {
        return LocalDateTime.parse(String.valueOf(date));
    }

}
