package ru.slybeaver.truecalendar

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ru.slybeaver.slycalendarview.SlyCalendarDialog
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andreu on 16.11.2019.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callback: SlyCalendarDialog.Callback = object : SlyCalendarDialog.Callback {
            override fun onCancelled() {}
            override fun onDataSelected(
                    firstDate: Calendar?,
                    secondDate: Calendar?,
                    hours: Int,
                    minutes: Int
            ) {
                if (firstDate != null) {
                    if (secondDate == null) {
                        firstDate[Calendar.HOUR_OF_DAY] = hours
                        firstDate[Calendar.MINUTE] = minutes

                        toast(SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault()).format(firstDate.time))
                    } else {
                        toast(getString(
                                R.string.period,
                                SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault()).format(firstDate.time),
                                SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault()).format(secondDate.time)
                        ))
                    }
                }
            }
        }

        btnShowCalendar.setOnClickListener {

            SlyCalendarDialog(this, callback)
                    .setSingle(false)
                    //.setFirstMonday(false)
                    .show()
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btnShowAndroid.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                toast("$dayOfMonth/$monthOfYear/$year")
            }, year, month, day)
            dpd.show()
        }

        val d = DatePicker(this)
    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}