package com.example.yugiohlifepointscounter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.yugiohlifepointscounter.R
import java.util.*

class MainActivity : AppCompatActivity() {

    private var START_TIME_IN_MILLIS: Long = 2400000
    private var timeLeftInMillis = START_TIME_IN_MILLIS


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.timer_textview).setOnClickListener {
            Toast.makeText(this@MainActivity, "IT'S TIME TO DUEL!", Toast.LENGTH_SHORT).show()
            startTimeCounter()
        }

        findViewById<Button>(R.id.btn_left_addition).setOnClickListener { additionLeftButton() }
        findViewById<Button>(R.id.btn_right_addition).setOnClickListener { additionRightButton() }

    }

    fun onDigit(view: View) {
        findViewById<TextView>(R.id.tvInput).append((view as Button).text)
    }

    fun clearAction(view: View) {
        findViewById<TextView>(R.id.tvInput).text = ""
    }

    private fun additionLeftButton() {
        val playerOneLP = findViewById<TextView>(R.id.tvInput).text.toString()

        if(playerOneLP == ""){
            displayLeft(findViewById<TextView>(R.id.player_one_lp_textview).text.toString().toInt() + 0)
        } else{
            displayLeft(findViewById<TextView>(R.id.player_one_lp_textview).text.toString().toInt() + playerOneLP.toInt())
        }
    }

    private fun displayLeft(number: Int) {
        val displayInteger = findViewById<TextView>(R.id.player_one_lp_textview)
        displayInteger.text = "" + number
    }

    private fun additionRightButton() {
        val playerOneLP = findViewById<TextView>(R.id.tvInput).text.toString()

        if(playerOneLP == ""){
            displayRight(findViewById<TextView>(R.id.player_two_lp_textview).text.toString().toInt() + 0)
        } else{
            displayRight(findViewById<TextView>(R.id.player_two_lp_textview).text.toString().toInt() + playerOneLP.toInt())
        }
    }

    private fun displayRight(number: Int) {
        val displayInteger = findViewById<TextView>(R.id.player_two_lp_textview)
        displayInteger.text = "" + number
    }

    private fun startTimeCounter() {
        val countTime: TextView = findViewById(R.id.timer_textview)

        object : CountDownTimer(START_TIME_IN_MILLIS, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
                countTime.isClickable = false
            }

            override fun onFinish() {
                countTime.text = "Done!"
                countTime.isClickable = true
            }
        }.start()
    }

    private fun updateCountDownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)

        findViewById<TextView>(R.id.timer_textview).text = timeLeftFormatted
    }
}