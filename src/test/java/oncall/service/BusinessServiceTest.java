package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.StaffFinder;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;
import org.junit.jupiter.api.Test;

class BusinessServiceTest {
    private final OnCallService onCallService = new OnCallService();
    private final SettingService settingService = new SettingService();

    @Test
    void 온콜_출력_확인() {
        Schedule schedule = new Schedule(5, "월");

        List<String> day = new ArrayList<>(List.of("12", "34", "56", "78", "89"));
        List<String> end = new ArrayList<>(List.of("78", "89", "56", "34", "12"));

        InputWeekdayStaffsDto dayDto = new InputWeekdayStaffsDto(day);
        InputWeekendStaffsDto endDto = new InputWeekendStaffsDto(end);

        StaffFinder staffs = settingService.createStaffs(dayDto, endDto);

        OnCallSchedule onCallSchedule = onCallService.schedule(schedule, staffs);
        System.out.println(onCallSchedule);

    }

}