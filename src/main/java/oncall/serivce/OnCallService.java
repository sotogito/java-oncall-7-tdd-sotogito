package oncall.serivce;

import oncall.domain.OnCallPolicy;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.Staffs;
import oncall.domain.heplers.BasicSortHelper;
import oncall.domain.heplers.ContinuousWorkSwitcher;

public class OnCallService {
    private final BasicSortHelper basicSortHelper;
    private final OnCallPolicy policySortHelper;

    public OnCallService() {
        this.basicSortHelper = new BasicSortHelper();
        this.policySortHelper = new ContinuousWorkSwitcher();
    }

    //note 정렬된 결과를 반환
    public OnCallSchedule schedule(Schedule schedule, Staffs staffs) {
        OnCallSchedule onCallSchedule = new OnCallSchedule();
        basicSorting(onCallSchedule, schedule, staffs);
        duplicateStaffProcessing(onCallSchedule);
        return onCallSchedule;
    }

    private void basicSorting(OnCallSchedule onCallSchedule, Schedule schedule, Staffs staffs) {
        basicSortHelper.sort(onCallSchedule, schedule, staffs);
        basicSortHelper.resetOrder();
    }

    private void duplicateStaffProcessing(OnCallSchedule onCallSchedule) {
        onCallSchedule.reSort(policySortHelper);
    }

}
