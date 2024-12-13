package oncall.domain.staff;

import java.time.LocalDate;
import java.util.Objects;
import oncall.constants.Week;
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

    private void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("직원의 이름은 1~5글자로 입력해주세요");
        }
    }

    public Staff getNewWorkTypeStaff(WorkType newWorkType, LocalDate newWorkDate) {
        Staff newStaff = new Staff(name, newWorkType);
        newStaff.setWorkDate(newWorkDate);
        return newStaff;
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

    /**
     * 5월 4일 목 수아 5월 5일 금(휴일) 루루
     *
     * @return
     */
    @Override
    public String toString() {
        int month = workDate.getMonthValue();
        int day = workDate.getDayOfMonth();
        String dayOfWeek = Week.findByDayOfWeek(workDate.getDayOfWeek()).getKorean();

        if (workType.equals(WorkType.HOLIDAY)) {
            return String.format("%d월 %d일 %s(휴일) %s\n", month, day, dayOfWeek, name);
        }
        return String.format("%d월 %d일 %s %s\n", month, day, dayOfWeek, name);

    }

}
