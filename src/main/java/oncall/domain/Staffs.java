package oncall.domain;

import java.util.EnumMap;
import oncall.constants.WorkType;
import oncall.domain.staff.OnCallStaff;

/**
 * 그냥 Map으로 생성하는게 맞는듯
 */
public class Staffs {
    private final EnumMap<WorkType, OnCallStaff> staffs = new EnumMap<>(WorkType.class);

    public Staffs(OnCallStaff weekday, OnCallStaff weekend) {
        staffs.put(WorkType.WEEKDAY, weekday);
        staffs.put(WorkType.WEEKEND, weekend);
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
