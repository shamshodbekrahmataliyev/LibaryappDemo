package itcenter.dangara.libaryappdemo.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.databinding.ActivityPasswordRecoveryBinding

class PasswordRecoveryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendSMS.setOnClickListener {
            val intent = Intent(this@PasswordRecoveryActivity, SmsVerificationActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener{
            finish()
        }

    }
}