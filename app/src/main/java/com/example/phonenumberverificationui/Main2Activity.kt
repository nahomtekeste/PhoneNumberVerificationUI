package com.example.phonenumberverificationui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn_resend.setOnClickListener{
            Toast.makeText(
                applicationContext,
                "We have sent verifiy number to $+mobile_number" ,
                Toast.LENGTH_SHORT
            ).show()

        }
        // this funtion allow the user to able to verfiy the number
        btn_verify.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (otp_box_1.text.toString() == "" || otp_box_2.text.toString() == "" || otp_box_3.text.toString() == "")
                    Toast.makeText(
                        applicationContext,
                        "Please enter the verifiy no.",
                        Toast.LENGTH_SHORT
                    ).show()
                else if (otp_box_1.text.length < 3 && otp_box_2.text.length < 6 || otp_box_2.text.length >3)
                    Toast.makeText(
                        applicationContext,
                        "Please enter correct number no.",
                        Toast.LENGTH_SHORT
                    ).show()
                else {
                    Toast.makeText(
                        applicationContext,
                        "You have verified the correct number.",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(applicationContext, HomeActivity ::class.java)
                    startActivity(intent)

                }

            }
})
    }
}
