package examen1.p1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilsTest {
    private final DateUtils dateUtils = new DateUtils();

    @Test
    public void testGetDayOfWeek_2024() {
        assertEquals("MONDAY", dateUtils.getDayOfWeek("2024-01-01"));
        assertEquals("SUNDAY", dateUtils.getDayOfWeek("2024-01-07"));
        assertEquals("TUESDAY", dateUtils.getDayOfWeek("2024-01-09"));
        assertEquals("FRIDAY", dateUtils.getDayOfWeek("2024-01-12"));
        assertEquals("WEDNESDAY", dateUtils.getDayOfWeek("2024-01-31"));
        assertEquals("SUNDAY", dateUtils.getDayOfWeek("2024-02-04"));
        assertEquals("FRIDAY", dateUtils.getDayOfWeek("2024-02-09"));
        assertEquals("THURSDAY", dateUtils.getDayOfWeek("2024-02-29"));
        assertEquals("SATURDAY", dateUtils.getDayOfWeek("2024-03-02"));
        assertEquals("MONDAY", dateUtils.getDayOfWeek("2024-12-30"));
        assertEquals("TUESDAY", dateUtils.getDayOfWeek("2024-12-31"));
    }

    @Test
    public void testGetDayOfWeek_InvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDayOfWeek("2024-01-32");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDayOfWeek("2024-02-30");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDayOfWeek("invalid-date");
        });
    }
}
