package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnCallSchedule {
    private final List<Staff> staffs;

    public OnCallSchedule() {
        this.staffs = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        staffs.add(staff.getNewStaff());
    }

    public void sort(){
        staffs.sort(null);
    }

    //note LocalDate의 day-1
    public void changeOrder(int day1, int day2) {
        Collections.swap(staffs, day1-1, day2-1);
    }

    public List<Staff> getStaffs() {
        return Collections.unmodifiableList(staffs);
    }

    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder();

        for (Staff staff : staffs) {
            System.out.println(staff);
            printOut.append(staff);
            printOut.append("\n");
        }
        return printOut.toString();
    }

}
