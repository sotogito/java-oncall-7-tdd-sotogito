package oncall.constant;

public enum WorkType {
    WEEKDAY(false),
    WEEKEND(true);

    private final boolean isWeekend;

    WorkType(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

}
