package oncall.constant;

import java.time.DayOfWeek;

public enum DayOfTheWeek {
    SUNDAY(DayOfWeek.SUNDAY, "일", true),
    MONDAY(DayOfWeek.MONDAY, "월", false),
    TUESDAY(DayOfWeek.TUESDAY, "화", false),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "수", false),
    THURSDAY(DayOfWeek.THURSDAY, "목", false),
    FRIDAY(DayOfWeek.FRIDAY, "금", false),
    SATURDAY(DayOfWeek.SATURDAY, "토", true);

    private final DayOfWeek dayOfWeek;
    private final String korean;
    private final boolean isWeekend;

    DayOfTheWeek(DayOfWeek dayOfWeek, String korean, boolean isWeekend) {
        this.dayOfWeek = dayOfWeek;
        this.korean = korean;
        this.isWeekend = isWeekend;
    }

    public String getKorean() {
        return korean;
    }

    //note 현재 주말인지 모기 위함
    public static boolean isWeekend(DayOfWeek other) {
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            if (dayOfTheWeek.dayOfWeek.equals(other)) {
                return dayOfTheWeek.isWeekend;
            }
        }
        return false;
    }

    public static DayOfTheWeek find(DayOfWeek dayOfWeek) {
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            if (dayOfTheWeek.dayOfWeek.equals(dayOfWeek)) {
                return dayOfTheWeek;
            }
        }
        throw new IllegalArgumentException("요일 오류");
    }

}
