package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import oncall.constant.WorkType;
import org.junit.jupiter.api.Test;

class StaffsTest {
    Staff staff1 = new Staff("가",WorkType.WEEKDAY);
    Staff staff2 = new Staff("가",WorkType.WEEKEND);

    Staff staff3 = new Staff("나",WorkType.WEEKDAY);
    Staff staff4 = new Staff("나",WorkType.WEEKEND);

    Staff staff5 = new Staff("다",WorkType.WEEKDAY);
    Staff staff6 = new Staff("다",WorkType.WEEKEND);

    Staff staff7 = new Staff("라",WorkType.WEEKDAY);
    Staff staff8 = new Staff("라",WorkType.WEEKEND);

    Staff staff9 = new Staff("마",WorkType.WEEKDAY);
    Staff staff10 = new Staff("마",WorkType.WEEKEND);

    @Test
    void validateSize(){
        EnumMap<WorkType, List<Staff>> staffs = new EnumMap<>(WorkType.class);
        staffs.put(WorkType.WEEKDAY, List.of(staff1,staff3,staff5));
        staffs.put(WorkType.WEEKEND, List.of(staff2,staff4,staff6));

        assertThatThrownBy(() -> new Staffs(staffs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateSameStaffs_인원수(){
        EnumMap<WorkType, List<Staff>> staffs = new EnumMap<>(WorkType.class);
        staffs.put(WorkType.WEEKDAY, List.of(staff1,staff3,staff5,staff8,staff9,staff10));
        staffs.put(WorkType.WEEKEND, List.of(staff2,staff4,staff6,staff8,staff9));

        assertThatThrownBy(() -> new Staffs(staffs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateSameStaffs_동일하지_않은_스태프(){
        EnumMap<WorkType, List<Staff>> staffs = new EnumMap<>(WorkType.class);
        staffs.put(WorkType.WEEKDAY, List.of(staff1,staff3,staff5,staff8,staff9,staff10));
        staffs.put(WorkType.WEEKEND, List.of(staff2,staff4,staff6,staff8,staff9,staff7));

        assertThatThrownBy(() -> new Staffs(staffs))
                .isInstanceOf(IllegalArgumentException.class);
    }

}