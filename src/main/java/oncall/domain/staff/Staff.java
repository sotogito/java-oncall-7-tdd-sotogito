package oncall.domain.staff;

import java.time.LocalDate;
import java.util.Objects;
import oncall.constants.WorkType;

public class Staff implements Comparable<Staff> {
    private final String name;
    private final WorkType workType;
    private LocalDate workDate;

    public Staff(String name, WorkType workType) {
        validateNameLength(name);
        this.name = name;
        this.workType = workType;
    }


    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("직원의 이름은 1~5글자로 입력해주세요");
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
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Staff o) {
        return this.workDate.compareTo(o.workDate);
    }

    @Override
    public String toString() {
        return name;
    }

}
