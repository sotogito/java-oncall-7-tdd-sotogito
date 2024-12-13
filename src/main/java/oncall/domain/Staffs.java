package oncall.domain;

import java.util.EnumMap;
import oncall.constants.WorkType;
import oncall.domain.staff.OnCallStaff;
import oncall.domain.staff.Staff;

/**
 * 그냥 Map으로 생성하는게 맞는듯
 */
public class Staffs {
    private final EnumMap<WorkType, OnCallStaff> staffs = new EnumMap<>(WorkType.class);

    public Staffs(OnCallStaff weekday, OnCallStaff weekend) {
        staffs.put(WorkType.WEEKDAY, weekday);
        staffs.put(WorkType.WEEKEND, weekend);
    }


    public Staff findStaffByOrder(WorkType workType, int order) {
        OnCallStaff workTypeStaffs = staffs.get(workType);
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
