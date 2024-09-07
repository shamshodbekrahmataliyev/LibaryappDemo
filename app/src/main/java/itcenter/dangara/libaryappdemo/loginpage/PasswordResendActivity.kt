package itcenter.dangara.libaryappdemo.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.R
import itcenter.dangara.libaryappdemo.databinding.ActivityPasswordResendBinding

class PasswordResendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordResendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordResendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginBack.setOnClickListener {
            startActivity(Intent(this , LoginActivity::class.java))
            finish()
        }
    }
}