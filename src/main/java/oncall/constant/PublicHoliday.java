package oncall.constant;

import java.time.LocalDate;

public enum PublicHoliday {

    NEW_YEAR(1,1),
    MARCH_1ST(3,1),
    CHILDREN(5,5),
    MEMORIAL(6,6),
    LIBERATION(8,15),
    NATIONAL_FOUNDATION(10,3),
    HANGUL(10,9),
    CHRISTMAS(12,25);

    private final int month;
    private final int day;

    PublicHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    //note 공휴일인지 보기 우ㅏㅎㅁ
    public static boolean isHoliday(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        for (PublicHoliday holiday : PublicHoliday.values()) {
            if (month == holiday.month && day == holiday.day) {
                return true;
            }
        }
        return false;
    }

}
