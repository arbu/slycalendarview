package ru.slybeaver.slycalendarview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.slybeaver.slycalendarview.listeners.DateSelectListener
import ru.slybeaver.slycalendarview.listeners.GridChangeListener
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andreu on 18.11.2019.
 */

class MonthPagerAdapterNew(
        private val slyCalendarData: SlyCalendarData,
        private val listener: DateSelectListener
) : RecyclerView.Adapter<MonthPagerAdapterNewViewHolder>() {

    private val tags = arrayListOf<Any>()



    private val colors = intArrayOf(
            android.R.color.black,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_dark,
            android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthPagerAdapterNewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slycalendar_calendar, parent, false)
        return MonthPagerAdapterNewViewHolder(view)
    }

    override fun getItemCount(): Int = Integer.MAX_VALUE



    override fun onBindViewHolder(holder: MonthPagerAdapterNewViewHolder, position: Int) = holder.itemView.run {
        val indexShift = itemCount

        val adapter = GridAdapter(this.context, slyCalendarData, indexShift, listener, object : GridChangeListener {
            override fun gridChanged() {
                tags.add(MonthPagerAdapter.TAG_PREFIX + (position + 1))
                tags.add(MonthPagerAdapter.TAG_PREFIX + (position - 1))
                notifyDataSetChanged()
            }
        })
        (this.findViewById<View>(R.id.calendarGrid) as GridView).adapter = adapter
        val currentDate = Calendar.getInstance()
        currentDate.time = slyCalendarData.showDate
        currentDate.add(Calendar.MONTH, indexShift)
        (this.findViewById<View>(R.id.txtSelectedMonth) as TextView).text = SimpleDateFormat("LLLL yyyy", Locale.getDefault()).format(currentDate.time)
        this.tag = MonthPagerAdapter.TAG_PREFIX + position
        //container.addView(view)
        val weekDays = Calendar.getInstance()
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 2 else 1
        (this.findViewById<View>(R.id.day1) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 3 else 2
        (this.findViewById<View>(R.id.day2) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 4 else 3
        (this.findViewById<View>(R.id.day3) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 5 else 4
        (this.findViewById<View>(R.id.day4) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 6 else 5
        (this.findViewById<View>(R.id.day5) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 7 else 6
        (this.findViewById<View>(R.id.day6) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (slyCalendarData.firstMonday) 1 else 7
        (this.findViewById<View>(R.id.day7) as TextView).text = SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(0, 1).toUpperCase() + SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time).substring(1)
    }
}

class MonthPagerAdapterNewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)