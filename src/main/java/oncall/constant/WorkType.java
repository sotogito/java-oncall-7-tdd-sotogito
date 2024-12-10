package oncall.constant;

public enum WorkType {
    WEEKDAY(false),
    WEEKEND(true),
    HOLIDAY(true);

    private final boolean isWeekend;

    WorkType(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

}
