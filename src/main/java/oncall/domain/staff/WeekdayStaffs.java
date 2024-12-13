package oncall.domain.staff;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WeekdayStaffs implements OnCallStaff {
    private final List<Staff> weekdays;

    public WeekdayStaffs(List<Staff> weekdays) {
        validateDuplicate(weekdays);
        validateStaffCount(weekdays);
        this.weekdays = weekdays;
    }

    public void validateDuplicate(List<Staff> staffs) {
        Set<Staff> carSet = new HashSet<>();
        for (Staff staff : staffs) {
            if (!carSet.add(staff)) {
                throw new IllegalArgumentException("중복된 이름의 평일 근무자가 존재합니다.");
            }
        }
    }

    private void validateStaffCount(List<Staff> staffs) {
        if (staffs.size() < 5 || staffs.size() > 35) {
            throw new IllegalArgumentException("직원은 총 5~35명까지 입력가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeekdayStaffs that = (WeekdayStaffs) o;
        return Objects.equals(new HashSet<>(weekdays), new HashSet<>(that.weekdays));
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekdays);
    }

    @Override
    public String toString() {
        return weekdays.toString();
    }

}
