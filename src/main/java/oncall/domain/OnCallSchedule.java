package oncall.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import oncall.constants.WorkType;
import oncall.domain.staff.Staff;

public class OnCallSchedule {
    private final List<Staff> staffList;

    public OnCallSchedule() {
        this.staffList = new ArrayList<>();
    }

    public void addStaffByNew(Staff staff, WorkType newWorkType, LocalDate newWorkDate) {
        this.staffList.add(staff.getNewWorkTypeStaff(newWorkType, newWorkDate));
    }

    public void sortByDate() {
        staffList.sort(Comparable::compareTo);
    }


    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();
        for (Staff staff : staffList) {
            printout.append(staff);
        }
        return printout.toString();
    }

}
