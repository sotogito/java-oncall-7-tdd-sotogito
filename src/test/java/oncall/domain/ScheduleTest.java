package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import oncall.constant.DayOfTheWeek;
import oncall.constant.PublicHoliday;
import org.junit.jupiter.api.Test;

class ScheduleTest {
    @Test
    void validateMonth(){
        assertThatThrownBy(() -> new Schedule(13,"월"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDayOfWeek(){
        assertThatThrownBy(() -> new Schedule(5,"화"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}