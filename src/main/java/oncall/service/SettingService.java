package oncall.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import oncall.constants.WorkType;
import oncall.domain.Schedule;
import oncall.domain.StaffFinder;
import oncall.domain.dto.InputScheduleDto;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;
import oncall.domain.staff.Staff;
import oncall.domain.staff.Staffs;

public class SettingService {

    public Schedule createSchedule(InputScheduleDto dto) {
        return new Schedule(dto.month(), dto.dayOfTheWeek());
    }

    public StaffFinder createStaffs(InputWeekdayStaffsDto dayDto, InputWeekendStaffsDto endDto) {
        EnumMap<WorkType, Staffs> result = new EnumMap<>(WorkType.class);

        List<Staff> dayStaffs = new ArrayList<>();
        for (String dayName : dayDto.weekdayStaffs()) {
            dayStaffs.add(new Staff(dayName, WorkType.WEEKDAY));
        }

        List<Staff> endStaffs = new ArrayList<>();
        for (String endName : endDto.weekendStaffs()) {
            endStaffs.add(new Staff(endName, WorkType.WEEKEND));
        }

        result.put(WorkType.WEEKDAY, new Staffs(dayStaffs));
        result.put(WorkType.WEEKEND, new Staffs(endStaffs));

        return new StaffFinder(result);
    }


}
