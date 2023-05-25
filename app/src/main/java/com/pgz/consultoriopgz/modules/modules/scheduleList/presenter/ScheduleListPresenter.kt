package com.pgz.consultoriopgz.modules.modules.scheduleList.presenter

import com.pgz.consultoriopgz.modules.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.modules.utils.SessionCache

class ScheduleListPresenter(var view: ScheduleListContract.View): ScheduleListContract.Presenter {

    override fun validateListForShowListOrBanner() {
        if (SessionCache.listSchedules.isEmpty()){
            view.showEmptyBanner()
        }else{
            view.showListSchedule()
        }
    }

}