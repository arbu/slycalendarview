package ru.slybeaver.slycalendarview

import android.app.AlertDialog
import android.content.Context
import androidx.annotation.StyleRes
import android.view.LayoutInflater
import ru.slybeaver.slycalendarview.listeners.DialogCompleteListener
import java.util.*

/**
 * Created by Andreu on 16.11.2019.
 */
enum class DialogType {
    DATE, DATE_TIME
}

class SlyCalendarDialog @JvmOverloads constructor(
        context: Context,
        private var callback: Callback? = null,
        type: DialogType = DialogType.DATE,
        @StyleRes themeResId: Int = 0
): AlertDialog(context, themeResId), DialogCompleteListener {

    private val slyCalendarData = SlyCalendarData()

    init {
        this.window?.attributes?.windowAnimations = R.style.DialogAnimation
        val inflater = LayoutInflater.from(context)
        val calendarView = inflater.inflate(R.layout.slycalendar_main, null) as SlyCalendarView
        calendarView.setSlyCalendarData(slyCalendarData)
        calendarView.setCallback(callback)
        calendarView.setType(type)
        calendarView.setCompleteListener(this)

        //val calendarView = inflater.inflate(R.layout.slycalendar_main, null)
//        calendarView.setSlyCalendarData(slyCalendarData)
//        calendarView.setCallback(callback)
//        calendarView.setType(type)
//        calendarView.setCompleteListener(this)

        setView(calendarView)
    }

    fun setEndDate(endDate: Date?): SlyCalendarDialog {
        slyCalendarData.selectedEndDate = endDate
        return this
    }


    fun setSingle(single: Boolean): SlyCalendarDialog {
        slyCalendarData.single = single
        return this
    }

    fun setFirstMonday(firsMonday: Boolean): SlyCalendarDialog {
        slyCalendarData.firstMonday = firsMonday
        return this
    }

    //TODO callback remove, add listener with lambda
//    fun setCallback(callback: Callback?): SlyCalendarDialog {
//        this.callback = callback
//        return this
//    }

    fun setTimeTheme(themeResource: Int?): SlyCalendarDialog {
        slyCalendarData.timeTheme = themeResource
        return this
    }

    fun getCalendarFirstDate(): Date? {
        return slyCalendarData.selectedStartDate
    }

    fun getCalendarSecondDate(): Date? {
        return slyCalendarData.selectedEndDate
    }

    override fun complete() {
        dismiss()
    }

    interface Callback {
        fun onCancelled()
        fun onDataSelected(firstDate: Calendar?, secondDate: Calendar?, hours: Int, minutes: Int)
    }

    fun setBackgroundColor(backgroundColor: Int?): SlyCalendarDialog {
        slyCalendarData.backgroundColor = backgroundColor
        return this
    }

    fun setHeaderColor(headerColor: Int?): SlyCalendarDialog {
        slyCalendarData.headerColor = headerColor
        return this
    }

    fun setHeaderTextColor(headerTextColor: Int?): SlyCalendarDialog {
        slyCalendarData.headerTextColor = headerTextColor
        return this
    }

    fun setTextColor(textColor: Int?): SlyCalendarDialog {
        slyCalendarData.textColor = textColor
        return this
    }

    fun setSelectedColor(selectedColor: Int?): SlyCalendarDialog {
        slyCalendarData.selectedColor = selectedColor
        return this
    }

    fun setSelectedTextColor(selectedTextColor: Int?): SlyCalendarDialog {
        slyCalendarData.selectedTextColor = selectedTextColor
        return this
    }

}