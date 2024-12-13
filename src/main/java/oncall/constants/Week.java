package oncall.constants;

import java.time.DayOfWeek;

public enum Week {
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

    Week(DayOfWeek dayOfWeek, String korean, boolean isWeekend) {
        this.dayOfWeek = dayOfWeek;
        this.korean = korean;
        this.isWeekend = isWeekend;
    }

    public String getKorean() {
        return korean;
    }

    public static Week findByDayOfWeek(DayOfWeek other) {
        for (Week week : values()) {
            if (week.dayOfWeek == other) {
                return week;
            }
        }
        throw new IllegalArgumentException("날짜 오류");
    }

}
