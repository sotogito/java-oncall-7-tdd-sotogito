package oncall.domain.staff;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WeekendStaffs implements OnCallStaff {

    private final List<Staff> weekends;

    public WeekendStaffs(List<Staff> weekends) {
        validateDuplicate(weekends);
        validateStaffCount(weekends);
        this.weekends = weekends;
    }

    public void validateDuplicate(List<Staff> staffs) {
        Set<Staff> carSet = new HashSet<>();
        for (Staff staff : staffs) {
            if (!carSet.add(staff)) {
                throw new IllegalArgumentException("중복된 이름의 주말 근무자가 존재합니다.");
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
        WeekendStaffs that = (WeekendStaffs) o;
        return Objects.equals(new HashSet<>(weekends), new HashSet<>(that.weekends));
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekends);
    }


}
