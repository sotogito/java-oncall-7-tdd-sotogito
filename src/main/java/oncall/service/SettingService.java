package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.constants.WorkType;
import oncall.domain.Schedule;
import oncall.domain.Staffs;
import oncall.domain.dto.InputScheduleDto;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;
import oncall.domain.staff.OnCallStaff;
import oncall.domain.staff.Staff;
import oncall.domain.staff.WeekdayStaffs;
import oncall.domain.staff.WeekendStaffs;

public class SettingService {

    public Schedule createSchedule(InputScheduleDto dto) {
        return new Schedule(dto.month(), dto.dayOfTheWeek());
    }

    public Staffs createStaffs(InputWeekdayStaffsDto dayDto, InputWeekendStaffsDto endDto) {
        List<Staff> dayStaffs = new ArrayList<>();
        for (String dayName : dayDto.weekdayStaffs()) {
            dayStaffs.add(new Staff(dayName, WorkType.WEEKDAY));
        }

        List<Staff> endStaffs = new ArrayList<>();
        for (String endName : endDto.weekendStaffs()) {
            endStaffs.add(new Staff(endName, WorkType.WEEKEND));
        }

        OnCallStaff day = new WeekdayStaffs(dayStaffs);
        OnCallStaff end = new WeekendStaffs(endStaffs);

        return new Staffs(day, end);
    }


}
