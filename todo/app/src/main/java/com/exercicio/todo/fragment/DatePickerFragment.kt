
package com.exercicio.todo.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment (
    val timepickerlistener: timerpickerlistenner
        ) : DialogFragment(),DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(),this,year,month,day)
    }

    override fun onDateSet(view: DatePicker?, p1: Int, p2: Int, p3: Int) {
      val calendario = Calendar.getInstance()
        calendario.set(Calendar.YEAR,p1)
        calendario.set(Calendar.MONTH,p2)
        calendario.set(Calendar.DAY_OF_MONTH,p3)

        timepickerlistener.onDateSelect(calendario.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate())
      }
    }


interface timerpickerlistenner{
    fun onDateSelect(date: LocalDate)
}
