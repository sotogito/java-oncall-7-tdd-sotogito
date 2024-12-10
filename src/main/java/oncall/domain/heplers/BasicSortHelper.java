package oncall.domain.heplers;

import java.time.LocalDate;
import oncall.constant.DayOfTheWeek;
import oncall.constant.PublicHoliday;
import oncall.constant.WorkType;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.Staff;
import oncall.domain.Staffs;

public class BasicSortHelper {
    private int dayOrder = 0;
    private int endOrder = 0;

    public void sort(OnCallSchedule onCallSchedule, Schedule schedule, Staffs staffs){
        LocalDate scheduleDate = schedule.getStartDate();
        int dayCount = schedule.getDayCount();

        for(int i = 1; i <= dayCount; i++){
            boolean isWeekend = DayOfTheWeek.isWeekend(scheduleDate.getDayOfWeek());
            boolean isHoliday = PublicHoliday.isHoliday(scheduleDate);

            Staff nowStaff = findStaff(staffs,isWeekend,isHoliday);
            onCallSchedule.addSchedule(scheduleDate,nowStaff);
            scheduleDate = scheduleDate.plusDays(1);
        }
    }

    public Staff findStaff(Staffs staffs, boolean isWeekend, boolean isHoliday){
        if(!isWeekend){
            if(isHoliday){
                return findStaffByBasicWorkType(staffs,WorkType.WEEKEND).
                        cloneAsNewWorkType(WorkType.HOLIDAY);
            }
            return findStaffByBasicWorkType(staffs,WorkType.WEEKDAY).
                    cloneAsNewWorkType(WorkType.WEEKDAY);

        }
        return findStaffByBasicWorkType(staffs,WorkType.WEEKEND).
                cloneAsNewWorkType(WorkType.WEEKEND);
    }

    private Staff findStaffByBasicWorkType(Staffs staffs, WorkType workType) {
        if(workType == WorkType.WEEKDAY){
            return staffs.findStaffByOrder(WorkType.WEEKDAY, dayOrder++);
        }
        return staffs.findStaffByOrder(WorkType.WEEKEND, endOrder++);
    }




    public void resetOrder(){
        endOrder = 0;
        dayOrder = 0;
    }

}
