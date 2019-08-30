package com.wiseassblog.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wiseassblog.calculator.buildlogic.DependencyProvider
import com.wiseassblog.calculator.userinterface.ICalculatorUI
import com.wiseassblog.calculator.userinterface.ViewEvent
import kotlinx.android.synthetic.main.activity_calculator.*

/**
 * Note: In a more complex App, I would use a Fragment for each UI screen and avoid using an Activity for that purpose
 * unless I was working with a Framework that required me to (Maps, Google Sign In, that kind of thing).
 */
class CalculatorActivity : AppCompatActivity(),
    View.OnClickListener,
    View.OnLongClickListener,
    ICalculatorUI.View {

    companion object {
        val DISPLAY_STATE = "STATE"
    }

    lateinit var logic: ICalculatorUI.Logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        logic = DependencyProvider.provideLogic(this)
        bindUserInterface()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(DISPLAY_STATE,  lbl_display.text.toString())
        super.onSaveInstanceState(outState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        lbl_display.text = savedInstanceState?.getString(DISPLAY_STATE, "")
    }

    private fun bindUserInterface() {
        btn_evaluate.setOnClickListener(this)
        btn_decimal.setOnClickListener(this)
        btn_display_delete.setOnClickListener(this)
        btn_display_delete.setOnLongClickListener(this)

        btn_number_one.setOnClickListener(this)
        btn_number_two.setOnClickListener(this)
        btn_number_three.setOnClickListener(this)
        btn_number_four.setOnClickListener(this)
        btn_number_five.setOnClickListener(this)
        btn_number_six.setOnClickListener(this)
        btn_number_seven.setOnClickListener(this)
        btn_number_eight.setOnClickListener(this)
        btn_number_nine.setOnClickListener(this)
        btn_number_zero.setOnClickListener(this)

        btn_operator_add.setOnClickListener(this)
        btn_operator_subtract.setOnClickListener(this)
        btn_operator_multiply.setOnClickListener(this)
        btn_operator_divide.setOnClickListener(this)
    }

    /* --------- Interface Functions --------*/

    override fun onLongClick(v: View?): Boolean {
        when (v?.id) {
            R.id.btn_display_delete -> logic.handleViewEvent(ViewEvent.DeleteAll)
        }

        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_evaluate -> logic.handleViewEvent(ViewEvent.Evaluate)
            R.id.btn_display_delete -> logic.handleViewEvent(ViewEvent.Delete)
            else -> {
                if (v is Button) {
                    logic.handleViewEvent(ViewEvent.Input(v.text.toString()))
                }
            }
        }
    }

    override var display: String
        get() = lbl_display.text.toString()
        set(value) {
            lbl_display.text = value
        }

    override fun showError(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }
}