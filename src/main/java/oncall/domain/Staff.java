package oncall.domain;

import java.time.LocalDate;
import java.util.Objects;
import oncall.constant.DayOfTheWeek;
import oncall.constant.WorkType;

/**
 * 이름의 고유한 유효검사 필요로 인해
 */
public class Staff implements Comparable<Staff> {
    private final String name;
    private final WorkType workType;

    private LocalDate workDate;
    private boolean isHoliday;

    public Staff(String name, WorkType workType) {
        validateName(name);
        this.name = name;
        this.workType = workType;
        this.isHoliday = false;
    }

    public boolean isSameName(Staff other){
        return this.name.equals(other.name);
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public void setHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public Staff getNewStaff() {
        Staff newStaff = new Staff(name, workType);
        newStaff.setWorkDate(workDate);
        newStaff.setHoliday(isHoliday);
        return newStaff;
    }


    public void changeWorkDate(Staff frontOrderStaff) {
        LocalDate otherWorkDate = frontOrderStaff.workDate;
        frontOrderStaff.setWorkDate(workDate);
        workDate = otherWorkDate;
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
        return Objects.equals(name, staff.name);
               // Objects.equals(workType, staff.workType);
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
        int month = workDate.getMonthValue();
        int day = workDate.getDayOfMonth();
        DayOfTheWeek dayOfTheWeek = DayOfTheWeek.find(workDate.getDayOfWeek());
        String dayOfWeekKorean = dayOfTheWeek.getKorean();

        if(!workType.isWeekend() && isHoliday){
            return String.format("%d월 %d일 %s(휴일) %s",
                    month, day, dayOfWeekKorean, name);
        }
        return String.format("%d월 %d일 %s %s",
                month, day, dayOfWeekKorean,name);


    }
}
