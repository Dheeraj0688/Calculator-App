package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var test=true
    var oldNumber=""
    var op= "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun number_Event(view: View) {
        if(test==true)
        {
            input.setText("")
            test=false
        }
        var buclick=input.text.toString()
        var buselect=view as Button
        when(buselect)
        {
            id_button_one ->{ buclick +="1"}
            id_button_two ->{ buclick +="2"}
            id_button_three ->{ buclick +="3"}
            id_button_four ->{ buclick +="4"}
            id_button_five ->{ buclick +="5"}
            id_button_six ->{ buclick +="6"}
            id_button_seven ->{ buclick +="7"}
            id_button_eight ->{ buclick +="8"}
            id_button_nine ->{ buclick +="9"}
            id_button_zero ->{ buclick +="0"}
            id_button_dot->{buclick +="."}
            id_button_plusminus ->{buclick = "-$buclick" }
        }
        input.setText(buclick)
    }

    fun operator_event(view: View) {
        test=true
        oldNumber = input.text.toString()
        var buselect=view as Button
        when(buselect.id){
            id_button_multiply.id->{op="×"}
            id_button_plus.id->{op="+"}
            id_button_minus.id->{op="-"}
            id_button_divide.id->{op="÷"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber=input.text.toString()
        var result=0.0
        when(op) {
            "+"->{result=oldNumber.toDouble() + newNumber.toDouble()}
            "-"->{result=oldNumber.toDouble() - newNumber.toDouble()}
            "×"->{result=oldNumber.toDouble() * newNumber.toDouble()}
            "÷"->{result=oldNumber.toDouble() / newNumber.toDouble()}
        }
        input.setText(result.toString())
        }

    fun acEvent(view: View) {
        input.setText("0")
        test=true
    }

    fun backPress(view: View) {
        var len=input.length()
        if(len>0)
        {
            input.text=input.text.subSequence(0,len-1)
        }
    }

}