package oncall.domain;

import java.time.LocalDate;
import oncall.constant.DayOfTheWeek;

public class Schedule {
    private final LocalDate date;

    public Schedule(int month, String dayOfWeek) {
        validateMonth(month);
        LocalDate scheduleDate = LocalDate.of(2023, month, 1);
        validateDayOfWeek(scheduleDate, dayOfWeek);

        this.date = scheduleDate;
    }

    public int getDayCount() {
        return date.lengthOfMonth();
    }

    public LocalDate getStartDate() {
        return date;
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요. - 월");
        }
    }

    private void validateDayOfWeek(LocalDate localDate, String input) {
        DayOfTheWeek realDayOfWeek = DayOfTheWeek.find(localDate.getDayOfWeek());
        if (!realDayOfWeek.getKorean().equals(input)) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요. - 요일");
        }
    }

}
