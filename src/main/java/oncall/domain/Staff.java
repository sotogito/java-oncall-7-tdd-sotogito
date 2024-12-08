package oncall.domain;

import java.time.LocalDate;
import java.util.Objects;
import oncall.constant.WorkType;

/**
 * 이름의 고유한 유효검사 필요로 인해
 */
public class Staff implements Comparable<Staff> {
    private final String name;
    private final WorkType workType;
    private LocalDate workDate;

    public Staff(String name, WorkType workType) {
        validateName(name);
        this.name = name;
        this.workType = workType;
    }

    public WorkType getWorkType() {
        return workType;
    }

    private void validateName(String name) {
        if(name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name) &&
                Objects.equals(workType, staff.workType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workType);
    }


    @Override
    public int compareTo(Staff o) {
        return this.workDate.compareTo(o.workDate);
    }



}
