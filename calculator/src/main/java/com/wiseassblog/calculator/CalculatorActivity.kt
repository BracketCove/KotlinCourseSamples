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

    lateinit var logic: ICalculatorUI.Logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logic = DependencyProvider.provideLogic(this)
        bindUserInterface()

        setContentView(R.layout.activity_calculator)
    }

    private fun bindUserInterface() {
        btnEvaluate.setOnClickListener(this)
        btnDecimal.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
        btnDelete.setOnLongClickListener(this)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnZero.setOnClickListener(this)

        btnAdd.setOnClickListener(this)
        btnSubtract.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
    }

    /* ----------- Interface Functions ----------*/

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnEvaluate -> logic.handleViewEvent(ViewEvent.Evaluate)
            R.id.btnDelete -> logic.handleViewEvent(ViewEvent.Delete)
            else -> {
                if (v is Button){
                    logic.handleViewEvent(ViewEvent.Input(
                        v.text.toString()
                    )
                    )
                }
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        when (v?.id) {
            R.id.btnDelete -> logic.handleViewEvent(ViewEvent.DeleteAll)
        }

        //return true if we don't want the onClick to be called next
        return true
    }

    override var display: String
        get() = lblDisplay.text.toString()
        set(value) {
            lblDisplay.text = value
        }

    override fun showError(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }

}