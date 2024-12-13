package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import oncall.constants.Week;

public class Schedule {
    private static final int startDay = 1;
    private final int month;
    private final String startDayOfWeek;

    public Schedule(int month, String startDayOfWeek) {
        validateMonth(month);
        validateStartDayOrWeek(month, startDayOfWeek);

        this.month = month;
        this.startDayOfWeek = startDayOfWeek;
    }

    public LocalDate getStartDate() {
        return LocalDate.of(2023, month, startDay);
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("올바른 '월'을 입력해주세요.");
        }
    }

    private void validateStartDayOrWeek(int month, String startDayOfWeek) {
        LocalDate startDate = LocalDate.of(2023, month, startDay);
        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        Week week = Week.findByDayOfWeek(dayOfWeek);

        if (!week.getKorean().equals(startDayOfWeek)) {
            throw new IllegalArgumentException("시작 요일을 다시 입력해주세요");
        }
    }

}
