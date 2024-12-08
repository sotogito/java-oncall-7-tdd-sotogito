package oncall.serivce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import javax.naming.spi.StateFactory;
import oncall.constant.WorkType;
import oncall.domain.Schedule;
import oncall.domain.Staff;
import oncall.domain.Staffs;
import org.junit.jupiter.api.Test;

class OnCallServiceTest {
    Staff staff1 = new Staff("가", WorkType.WEEKDAY);
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
    void 기본정렬출력확인(){
        EnumMap<WorkType, List<Staff>> staffList = new EnumMap<>(WorkType.class);
        staffList.put(WorkType.WEEKDAY, List.of(staff1,staff3,staff5,staff7,staff9));
        staffList.put(WorkType.WEEKEND, List.of(staff2,staff4,staff6,staff8,staff10));

        Schedule schedule = new Schedule(5,"월");
        Staffs staffs1 = new Staffs(staffList);

        OnCallService onCallService = new OnCallService();
        onCallService.schedule(schedule,staffs1);
    }

}