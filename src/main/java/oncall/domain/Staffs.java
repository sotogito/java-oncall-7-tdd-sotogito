package oncall.domain;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.constant.WorkType;

public class Staffs {
    //note 사실 WeekDay, WeekEnd 객체를 따로따로 만드느게 맞지만 코딩테스트에서는 조회가 어려울수도 있따.
    // 다음과 같은 형태라면 그냥 EnumMap을 사용하는게 빠르다.
    private final EnumMap<WorkType, List<Staff>> staffs;

    public Staffs(EnumMap<WorkType, List<Staff>> staffs) {
        List<Staff> weekdays = staffs.get(WorkType.WEEKDAY);
        List<Staff> weekends = staffs.get(WorkType.WEEKEND);
        validateSize(weekdays);
        validateSize(weekends);
        validateSameStaffs(weekdays, weekends);

        this.staffs = staffs;
    }

    public Staff findStaffByOrder(WorkType workType, int order) {
        List<Staff> staffList = staffs.get(workType);
        int index = order % staffList.size();
        return staffList.get(index);
    }

    private void validateSize(List<Staff> staffs) {
        if (staffs.size() < 5 || staffs.size() > 35) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.-1");
        }
    }

    private void validateSameStaffs(List<Staff> weekdays, List<Staff> weekends) {
        if (weekdays.size() != weekends.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.-2");
        }

        Set<Staff> staffSet = new HashSet<>(weekdays);
        staffSet.addAll(weekends);
        if (staffSet.size() != weekdays.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.-3");
        }
    }


}
