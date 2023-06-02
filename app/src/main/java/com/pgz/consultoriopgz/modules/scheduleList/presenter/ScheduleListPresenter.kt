package com.pgz.consultoriopgz.modules.scheduleList.presenter

import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity
import com.pgz.consultoriopgz.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.modules.scheduleList.repository.ScheduleListRepository
import com.pgz.consultoriopgz.utils.SessionCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ScheduleListPresenter(var view: ScheduleListContract.View): ScheduleListContract.Presenter {

    private val repository = ScheduleListRepository()

    override fun validateListForShowListOrBanner() {
        if (SessionCache.listSchedules.isEmpty()){
            view.showEmptyBanner()
        }else{
            view.showListSchedule()
        }
    }

    override fun removeScheduleCheck(scheduleList: ArrayList<ScheduleAppointmentEntity>){
        GlobalScope.launch(Dispatchers.IO) {
            try {
                scheduleList.forEach{schedule ->
                    repository.deleteSchedule(schedule)
                    SessionCache.listSchedules.remove(schedule)
                }
                SessionCache.listCheckToDeleteSchedule.clear()
                launch(Dispatchers.Main) {
                    view.updateList()
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    view.showError()
                }
            }
        }
    }

}