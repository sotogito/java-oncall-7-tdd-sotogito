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
        Staff staff1 = staffs.get(day1);
        Staff staff2 = staffs.get(day2);
        staff1.changeWorkDate(staff2);
    }

    public List<Staff> getStaffs() {
        return Collections.unmodifiableList(staffs);
    }

    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder();

        for (Staff staff : staffs) {
            printOut.append(staff);
            printOut.append("\n");
        }
        return printOut.toString();
    }

}
