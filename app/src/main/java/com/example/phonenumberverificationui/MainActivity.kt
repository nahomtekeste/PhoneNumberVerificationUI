package com.example.phonenumberverificationui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {


    internal lateinit var otp: TextView

    internal lateinit var generate_otp: Button

    internal lateinit var mobile_number: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {
                finish()
            }

        })

        otp = findViewById(R.id.otp)
        generate_otp = findViewById(R.id.generate_otp)
        mobile_number = findViewById(R.id.mobile_number)
        otp.text = Html.fromHtml(resources.getString(R.string.otp))

        // this code allow the user to send the number of the and allowed recived the number
        generate_otp.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (mobile_number.text.toString() == "")
                    Toast.makeText(
                        applicationContext,
                        "Please enter the mobile no.",
                        Toast.LENGTH_SHORT
                    ).show()
                else if (mobile_number.text.length < 10)
                    Toast.makeText(
                        applicationContext,
                        "Please enter correct mobile no.",
                        Toast.LENGTH_SHORT
                    ).show()
                else {

                    val intent = Intent(applicationContext, Main2Activity::class.java)
                    startActivity(intent)

                }


            }

        })


    }

}