package oncall.domain;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public interface OnCallPolicy {
    void sort(TreeMap<LocalDate, Staff> onCallSchedule);
}
