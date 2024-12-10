package oncall.controller;

import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.Staffs;
import oncall.domain.parser.ScheduleParser;
import oncall.domain.parser.StaffParser;
import oncall.dto.ScheduleDto;
import oncall.dto.WeekdayStaffsDto;
import oncall.dto.WeekendStaffsDto;
import oncall.serivce.OnCallService;
import oncall.serivce.OnCallSettingService;
import oncall.view.Input;
import oncall.view.Output;

public class OnCallMainController {
    private OnCallSettingService onCallSettingService;
    private OnCallService onCallService;

    public void run() {
        onCallSettingService = new OnCallSettingService();
        onCallService = new OnCallService();

        Schedule schedule = createSchedule();
        Staffs staffs = createStaff();

        OnCallSchedule onCallResult = onCallService.schedule(schedule, staffs);
        System.out.println(onCallResult);
    }

    private Staffs createStaff() {
        while (true) {
            try {
                WeekdayStaffsDto weekdayDto = StaffParser.parseWeekday(Input.inputWeekdayStaffs());
                WeekendStaffsDto weekendDto = StaffParser.parseWeekend(Input.inputWeekendStaffs());

                return onCallSettingService.createStaffs(weekdayDto, weekendDto);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Schedule createSchedule() {
        while (true) {
            try {
                ScheduleDto dto = ScheduleParser.parse(Input.inputDate());
                return onCallSettingService.createSchedule(dto);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
