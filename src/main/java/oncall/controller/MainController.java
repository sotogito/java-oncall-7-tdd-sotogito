package oncall.controller;

import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.StaffFinder;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;
import oncall.domain.parsers.InputScheduleParser;
import oncall.domain.parsers.InputStaffParser;
import oncall.service.OnCallService;
import oncall.service.SettingService;
import oncall.view.Input;
import oncall.view.Output;

public class MainController {
    private SettingService settingService;
    private OnCallService onCallService;

    public MainController() {
        settingService = new SettingService();
        onCallService = new OnCallService();
    }

    public void run() {
        Schedule schedule = createSchedule();
        StaffFinder staffs = createStaffs();

        OnCallSchedule onCallScheduleResult = onCallService.schedule(schedule, staffs);
        System.out.println(onCallScheduleResult);
    }


    private Schedule createSchedule() {
        while (true) {
            try {
                return settingService.createSchedule(InputScheduleParser.parse(Input.inputSchedule()));
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private StaffFinder createStaffs() {
        while (true) {
            try {
                InputWeekdayStaffsDto weekday = InputStaffParser.parseWeekday(Input.inputWeekdayStaffs());
                InputWeekendStaffsDto weekend = InputStaffParser.parseWeekend(Input.inputWeekendStaffs());

                return settingService.createStaffs(weekday, weekend);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }

    }

}
