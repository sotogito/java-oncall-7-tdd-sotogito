package oncall.domain;

import java.util.Objects;
import oncall.constant.WorkType;

/**
 * isHoliday말고 workType Enum에 Holiday를 추가하여 관리
 */
public class Staff {
    private final String name;
    private final WorkType workType;

    public Staff(String name, WorkType workType) {
        validateName(name);
        this.name = name;
        this.workType = workType;
    }

    public Staff cloneAsNewWorkType(WorkType workType) {
        return new Staff(name, workType);
    }

    public WorkType getWorkType() {
        return workType;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
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
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name);
        // Objects.equals(workType, staff.workType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
