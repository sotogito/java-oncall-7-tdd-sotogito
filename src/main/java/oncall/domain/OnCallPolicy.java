package oncall.domain;

import java.time.LocalDate;
import java.util.Map;

public interface OnCallPolicy {
    void sort(Map<LocalDate, Staff> onCallSchedule);
}
