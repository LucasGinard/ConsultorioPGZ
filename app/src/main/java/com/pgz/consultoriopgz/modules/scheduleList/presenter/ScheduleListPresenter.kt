package com.pgz.consultoriopgz.modules.scheduleList.presenter

import com.pgz.consultoriopgz.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.utils.SessionCache

class ScheduleListPresenter(var view: ScheduleListContract.View): ScheduleListContract.Presenter {

    override fun validateListForShowListOrBanner() {
        if (SessionCache.listSchedules.isEmpty()){
            view.showEmptyBanner()
        }else{
            view.showListSchedule()
        }
    }

}