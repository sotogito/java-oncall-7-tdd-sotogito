package oncall.serivce;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import oncall.constant.WorkType;
import oncall.domain.Schedule;
import oncall.domain.Staff;
import oncall.domain.Staffs;
import oncall.dto.ScheduleDto;
import oncall.dto.WeekdayStaffsDto;
import oncall.dto.WeekendStaffsDto;

public class OnCallSettingService {

    public Schedule createSchedule(ScheduleDto scheduleDto) {
        int month = scheduleDto.month();
        String string = scheduleDto.startDayOfWeek();
        return new Schedule(month, string);
    }

    public Staffs createStaffs(WeekdayStaffsDto weekdayStaffs, WeekendStaffsDto weekendStaffs) {
        EnumMap<WorkType, List<Staff>> staffs = new EnumMap<>(WorkType.class);

        List<Staff> weekdays = new ArrayList<>();
        for (String weekdayStaffName : weekdayStaffs.weekdayStaffs()) {
            weekdays.add(new Staff(weekdayStaffName, WorkType.WEEKDAY));
        }

        List<Staff> weekends = new ArrayList<>();
        for (String weekendStaffName : weekendStaffs.weekendStaffs()) {
            weekends.add(new Staff(weekendStaffName, WorkType.WEEKEND));
        }

        staffs.put(WorkType.WEEKDAY, weekdays);
        staffs.put(WorkType.WEEKEND, weekends);

        return new Staffs(staffs);
    }

}
