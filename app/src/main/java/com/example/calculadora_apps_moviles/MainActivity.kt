package com.example.calculadora_apps_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var numActual = 0.0
    var numGuardado = 0.0
    var op = 0

    fun num_get (view: View){
        print(numActual)
        var btn = view as Button
        var getnumber = btn.text.toString()
        if(getnumber == "." && textviewresultado.text == "0"){
            getnumber = "0."
        }
        changetextview(getnumber, textviewresultado as View)
        numActual=textviewresultado.text.toString().toDouble()
    }

    fun changetextview (numberInString: String, view: View){
        var textv = view as TextView
        var textvText =textv.text.toString()
        if(textvText=="0"){
            textv.setText(numberInString)
        }else{
            textv.setText(textvText+numberInString)
        }
    }

    fun erasetextview (view: View){
        var textv = view as TextView
            textv.setText("")
    }

    fun clearWithAC (view: View){
        textviewresultado.setText("0")
        numActual = 0.0;
        numGuardado = 0.0;
        op=0;
        print("todo ok aqui x3")
    }

    fun positiveNegativeBtn (view: View){
        erasetextview(textviewresultado as View)
        if(numActual != 0.0){
            numActual=-numActual
            var _numActual = numActual.toString()
            changetextview(_numActual,textviewresultado as View)    
        }else{
            if(numGuardado != 0.0){
                numGuardado=-numGuardado
                var _numGuardado = numGuardado.toString()
                changetextview(_numGuardado,textviewresultado as View)
            }
        }
        
    }

    fun percent (view: View){
        erasetextview(textviewresultado as View)
        if(numActual!=0.0){
            numActual=numActual/100
            changetextview(numActual.toString(),textviewresultado as View)
        }else{
            numGuardado=numGuardado/100
            changetextview(numGuardado.toString(),textviewresultado as View)
        }

    }

    fun equal(view: View){
        textviewresultado.setText("")
        var numAString: String
        when(op){
            1->{
                numGuardado=numGuardado+numActual
                numAString=numGuardado.toString()
                changetextview(numAString, textviewresultado as View)
                numActual=0.0
            }
            2->{
                numGuardado=numGuardado-numActual
                numAString=numGuardado.toString()
                changetextview(numAString, textviewresultado as View)
                numActual=0.0
            }
            3->{
                numGuardado=numGuardado*numActual
                numAString=numGuardado.toString()
                changetextview(numAString, textviewresultado as View)
                numActual=0.0

            }
            4->{
                numGuardado=numGuardado/numActual
                numAString=numGuardado.toString()
                changetextview(numAString, textviewresultado as View)
                numActual=0.0
            }
        }
    }
    fun changeOperation (view: View){

        var operator = view as Button
        when (operator.text.toString()){
            "+"->{
                op=1
                if(numGuardado != 0.0){
                    numGuardado=textviewresultado.text.toString().toDouble() + numActual
                }else{
                    numGuardado=textviewresultado.text.toString().toDouble()
                }
                textviewresultado.setText("0")
                numActual=0.0
            }
            "-"->{
                op=2
                if(numGuardado != 0.0 && numActual != 0.0){
                    numGuardado=textviewresultado.text.toString().toDouble() - numActual
                }else{
                    numGuardado=textviewresultado.text.toString().toDouble()
                }
                textviewresultado.setText("0")
                numActual=0.0
            }
            "X"->{
                op=3
                if(numGuardado != 0.0 && numActual != 0.0){
                    numGuardado=textviewresultado.text.toString().toDouble() * numActual
                }else{
                    if(numActual != 0.0){
                        numGuardado=textviewresultado.text.toString().toDouble()
                    }
                }
                textviewresultado.setText("0")
                numActual=0.0
            }
            "/"->{
                op=4
                if(numGuardado != 0.0 && numActual != 0.0 ){
                    numGuardado=textviewresultado.text.toString().toDouble() / numActual
                }else{
                    numGuardado=textviewresultado.text.toString().toDouble()
                }
                textviewresultado.setText("0")
                numActual=0.0
            }
        }
    }



}