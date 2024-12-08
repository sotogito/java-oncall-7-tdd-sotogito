package oncall.constant;

import java.time.DayOfWeek;

public enum DayOfTheWeek {
    SUNDAY(DayOfWeek.SUNDAY,true),
    MONDAY(DayOfWeek.MONDAY,false),
    TUESDAY(DayOfWeek.TUESDAY,false),
    WEDNESDAY(DayOfWeek.WEDNESDAY,false),
    THURSDAY(DayOfWeek.THURSDAY,false),
    FRIDAY(DayOfWeek.FRIDAY,false),
    SATURDAY(DayOfWeek.SATURDAY,true);

    private final DayOfWeek dayOfWeek;
    private final boolean isWeekend;

    DayOfTheWeek(DayOfWeek dayOfWeek, boolean isWeekend) {
        this.dayOfWeek = dayOfWeek;
        this.isWeekend = isWeekend;
    }

    //note 현재 주말인지 모기 위함
    public static boolean isWeekend(DayOfWeek other) {
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            if(dayOfTheWeek.dayOfWeek.equals(other)){
                return dayOfTheWeek.isWeekend;
            }
        }
        return false;
    }

}
