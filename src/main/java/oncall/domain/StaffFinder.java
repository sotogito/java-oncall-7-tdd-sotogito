package oncall.domain;

import java.util.EnumMap;
import oncall.constants.WorkType;
import oncall.domain.staff.Staff;
import oncall.domain.staff.Staffs;

public class StaffFinder {
    private final EnumMap<WorkType, Staffs> staffs;

    public StaffFinder(EnumMap<WorkType, Staffs> staffs) {
        this.staffs = staffs;
    }

    public Staff findStaffByOrder(WorkType workType, int order) {
        Staffs workTypeStaffs = staffs.get(workType);
        int index = order % workTypeStaffs.getSize();

        return workTypeStaffs.getStaffByIndex(index);
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();
        for (WorkType workType : staffs.keySet()) {
            printout.append(workType).append(": ").append(staffs.get(workType).toString()).append("\n");
        }
        return printout.toString();
    }

}
