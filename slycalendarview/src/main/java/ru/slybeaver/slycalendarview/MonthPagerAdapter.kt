package ru.slybeaver.slycalendarview

import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import ru.slybeaver.slycalendarview.listeners.DateSelectListener
import ru.slybeaver.slycalendarview.listeners.GridChangeListener
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andreu on 16.11.2019.
 */
class MonthPagerAdapter (
        private val slyCalendarData: SlyCalendarData,
        private val listener: DateSelectListener
) : PagerAdapter() {

    private val tags = arrayListOf<Any>()

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        tags.remove((`object` as View).tag.toString())
        container.removeView(`object`)
    }

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val indexShift = position - count / 2
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.slycalendar_calendar, container, false) as ViewGroup
        val adapter = GridAdapter(container.context, slyCalendarData, indexShift, listener, object : GridChangeListener {
            override fun gridChanged() {
                tags.add(TAG_PREFIX + (position + 1))
                tags.add(TAG_PREFIX + (position - 1))
                notifyDataSetChanged()
            }
        })
        (view.findViewById<View>(R.id.calendarGrid) as GridView).adapter = adapter
        val currentDate = Calendar.getInstance()
        currentDate.time = slyCalendarData.showDate
        currentDate.add(Calendar.MONTH, indexShift)
        (view.findViewById<View>(R.id.txtSelectedMonth) as TextView).text = SimpleDateFormat("LLLL yyyy", Locale.getDefault()).format(currentDate.time)
        view.tag = TAG_PREFIX + position
        container.addView(view)
        val weekDays = Calendar.getInstance()
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 2 else 1
        (view.findViewById<View>(R.id.day1) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 3 else 2
        (view.findViewById<View>(R.id.day2) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 4 else 3
        (view.findViewById<View>(R.id.day3) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 5 else 4
        (view.findViewById<View>(R.id.day4) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 6 else 5
        (view.findViewById<View>(R.id.day5) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 7 else 6
        (view.findViewById<View>(R.id.day6) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 1 else 7
        (view.findViewById<View>(R.id.day7) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        return view
    }

    override fun getItemPosition(`object`: Any): Int {
        val tag = (`object` as ViewGroup).tag.toString()
        if (tags.contains(tag)) {
            tags.remove(tag)
            return POSITION_NONE
        }
        return POSITION_UNCHANGED
    }

    companion object {
        const val TAG_PREFIX = "SLY_CAL_TAG"
    }

}