package ru.slybeaver.slycalendarview

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.slybeaver.slycalendarview.listeners.DialogCompleteListener
import java.util.*

/**
 * Created by Andreu on 16.11.2019.
 */
class SlyCalendarDialog : DialogFragment(), DialogCompleteListener {

    private val slyCalendarData = SlyCalendarData()
    private var callback: Callback? = null

    fun setStartDate(startDate: Date?): SlyCalendarDialog {
        slyCalendarData.selectedStartDate = startDate
        return this
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

    fun setCallback(callback: Callback?): SlyCalendarDialog {
        this.callback = callback
        return this
    }

    fun setTimeTheme(themeResource: Int?): SlyCalendarDialog {
        slyCalendarData.timeTheme = themeResource
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.SlyCalendarDialogStyle)
    }

    fun getCalendarFirstDate(): Date? {
        return slyCalendarData.selectedStartDate
    }

    fun getCalendarSecondDate(): Date? {
        return slyCalendarData.selectedEndDate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val calendarView = activity!!.layoutInflater.inflate(R.layout.slycalendar_main, container) as SlyCalendarView
        calendarView.setSlyCalendarData(slyCalendarData)
        calendarView.setCallback(callback)
        calendarView.setCompleteListener(this)
        return calendarView
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