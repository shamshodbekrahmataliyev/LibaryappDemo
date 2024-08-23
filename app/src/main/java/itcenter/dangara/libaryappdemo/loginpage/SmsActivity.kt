package itcenter.dangara.libaryappdemo.loginpage

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.MainActivity
import itcenter.dangara.libaryappdemo.R
import itcenter.dangara.libaryappdemo.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {

    private lateinit var timerText: TextView
    private lateinit var resendText: TextView
    private lateinit var countDownTimer: CountDownTimer
    private var timeLeftInMillis: Long = 120000
    private lateinit var binding: ActivitySmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timerText = findViewById(R.id.time)
        resendText = findViewById(R.id.resendsms)

        binding.back.setOnClickListener{
            finish()
        }

        startTimer()
        binding.verifyButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        resendText.setOnClickListener {
            resendText.visibility = View.GONE
            timeLeftInMillis = 120000
            startTimer()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimer()
            }

            override fun onFinish() {
                timerText.text = "00:00"
                resendText.visibility = View.VISIBLE
            }
        }.start()
    }

    private fun updateTimer() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeFormatted = String.format("%02d:%02d", minutes, seconds)
        timerText.text = timeFormatted
    }
}