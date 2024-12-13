package oncall.service;

import java.time.LocalDate;
import oncall.constants.PublicHoliday;
import oncall.constants.Week;
import oncall.constants.WorkType;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.StaffFinder;
import oncall.domain.staff.Staff;

public class OnCallService {


    public OnCallSchedule schedule(Schedule schedule, StaffFinder staffs) {
        OnCallSchedule onCallSchedule = new OnCallSchedule();
        LocalDate startDate = schedule.getStartDate();
        int monthCount = schedule.monthLength();

        basicSort(onCallSchedule, staffs, startDate, monthCount);
        switchContinuousWorker(onCallSchedule);
        return onCallSchedule;
    }

    private void basicSort(OnCallSchedule onCallSchedule, StaffFinder staffs, LocalDate date, int monthCount) {
        int dayCount = 0;
        int endCount = 0;

        for (int i = 0; i < monthCount; i++) {
            boolean isWeekend = Week.isWeekend(date);
            boolean isHoliday = PublicHoliday.isHoliday(date);
            Staff staff;

            while (true) {
                if (!isWeekend) { //note 평일
                    if (isHoliday) { //note 평일+주말 (휴일)
                        staff = staffs.findStaffByOrder(WorkType.WEEKEND, endCount);
                        onCallSchedule.addStaffByNew(staff, WorkType.HOLIDAY, date);
                        endCount++;
                        break;
                    }
                    staff = staffs.findStaffByOrder(WorkType.WEEKDAY, dayCount);
                    onCallSchedule.addStaffByNew(staff, WorkType.WEEKDAY, date);
                    dayCount++;
                    break;
                }
                //note 주말
                staff = staffs.findStaffByOrder(WorkType.WEEKEND, endCount);
                onCallSchedule.addStaffByNew(staff, WorkType.WEEKDAY, date);
                endCount++;
                break;
            }
            date = date.plusDays(1);
        }
        onCallSchedule.sortByDate();
    }

    private void switchContinuousWorker(OnCallSchedule onCallSchedule) {
        onCallSchedule.switchContinuousWorker();
    }

}
