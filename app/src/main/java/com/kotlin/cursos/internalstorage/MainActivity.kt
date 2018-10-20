package com.kotlin.cursos.internalstorage

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var PREF = "myPrefs"
    var myPref: SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultado_textView.text = ""

        save_Button.setOnClickListener {
            myPref = getSharedPreferences(PREF, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()
            if (!TextUtils.isEmpty(nombre_editText.text.toString())) {
                editor.putString("Nombres", nombre_editText.text.toString())
                Toast.makeText(this, "Almacenado", Toast.LENGTH_SHORT).show()
                editor.commit()
            } else {
                Toast.makeText(this, "Ingrese nombres", Toast.LENGTH_SHORT).show()
            }

            var retorno: SharedPreferences = getSharedPreferences(PREF, 0)
            if (retorno.contains("Nombres")) {
                resultado_textView.text = retorno.getString("Nombres", "Vacío")
            }
        }
    }


}
