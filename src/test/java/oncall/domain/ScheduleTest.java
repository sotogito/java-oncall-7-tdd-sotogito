package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ScheduleTest {

    @Test
    void 올바르지_않는_월_예외_처리() {
        assertThatThrownBy(() -> new Schedule(13, "월"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 올바르지_않는_시작_요일_예외_처리() {
        assertThatThrownBy(() -> new Schedule(5, "금"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}