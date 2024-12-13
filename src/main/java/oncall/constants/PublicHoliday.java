package oncall.constants;

import java.time.LocalDate;

public enum PublicHoliday {
    NEW_YEAR(1, 1),
    MARCH_1ST(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    LIBERATION(8, 15),
    NATIONAL_FOUNDATION(10, 3),
    HANGUL(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int day;

    PublicHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        for (PublicHoliday h : PublicHoliday.values()) {
            if (h.month == month && h.day == day) {
                return true;
            }
        }
        return false;
    }

}
