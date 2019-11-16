package ru.slybeaver.slycalendarview

import java.util.*

/**
 * Created by Andreu on 16.11.2019.
 */
@Suppress("SuspiciousVarProperty")
class SlyCalendarData(
        //current showing date
        showDate: Date? = null,

        // first selected date
        var selectedStartDate: Date? = null,
        // ended selected date
        var selectedEndDate: Date? = null,

        var selectedHour: Int = 0,

        var selectedMinutes: Int = 0,
        // is first monday
        var firstMonday: Boolean = true,

        var single: Boolean = true,

        var backgroundColor: Int? = null,

        var headerColor: Int? = null,

        var headerTextColor: Int? = null,

        var textColor: Int? = null,

        var selectedColor: Int? = null,

        var selectedTextColor: Int? = null,

        var timeTheme: Int? = null
) {
    //current showing date
    var showDate: Date? = null
        get() {
            if (field == null) {
                this.showDate = if (selectedStartDate != null) {
                    selectedStartDate!!.clone() as Date
                } else {
                    Calendar.getInstance().time
                }
            }
            return field
        }
}