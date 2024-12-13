package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.StaffFinder;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;
import org.junit.jupiter.api.Test;

class SettingServiceTest {
    private SettingService settingService = new SettingService();

    @Test
    void Staffs_생성_확인() {
        List<String> day = new ArrayList<>(List.of("12", "34", "56", "78", "89"));
        List<String> end = new ArrayList<>(List.of("12", "34", "56", "78", "89"));

        InputWeekdayStaffsDto dayDto = new InputWeekdayStaffsDto(day);
        InputWeekendStaffsDto endDto = new InputWeekendStaffsDto(end);

        StaffFinder staffs = settingService.createStaffs(dayDto, endDto);

        System.out.println(staffs);
    }

}