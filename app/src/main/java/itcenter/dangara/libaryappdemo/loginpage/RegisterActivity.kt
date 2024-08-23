package itcenter.dangara.libaryappdemo.loginpage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import itcenter.dangara.libaryappdemo.R
import itcenter.dangara.libaryappdemo.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var fullNameTxt: TextInputEditText
    private lateinit var emailTxt: TextInputEditText
    private lateinit var passwordTxt: TextInputEditText
    private lateinit var confirmPasswordTxt: TextInputEditText
    private lateinit var phoneNumberTxt: EditText

    private lateinit var fullNameLayout: TextInputLayout
    private lateinit var emailLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var confirmPasswordLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        fullNameTxt = findViewById(R.id.fullname)
        emailTxt = findViewById(R.id.email)
        passwordTxt = findViewById(R.id.password)
        confirmPasswordTxt = findViewById(R.id.confirmpassword)
        phoneNumberTxt = findViewById(R.id.phone_number)

        fullNameLayout = findViewById(R.id.email_layout)
        emailLayout = findViewById(R.id.emaiL)
        passwordLayout = findViewById(R.id.passworD)
        confirmPasswordLayout = findViewById(R.id.confirmP)

        val sendSMSButton = findViewById<MaterialButton>(R.id.sendSMS)

        sendSMSButton.setOnClickListener {
            val fullName = fullNameTxt.text.toString().trim()
            val email = emailTxt.text.toString().trim()
            val password = passwordTxt.text.toString().trim()
            val confirmPassword = confirmPasswordTxt.text.toString().trim()
            val phoneNumber = phoneNumberTxt.text.toString().trim()

            var isValid = true

            // Tekshiruvlar
            if (fullName.isEmpty()) {
                fullNameTxt.setText("!")
                fullNameTxt.setTextColor(Color.RED)
                fullNameLayout.error = null
                isValid = false
            } else {
                fullNameTxt.setTextColor(Color.BLACK)
            }

            if (email.isEmpty()) {
                emailTxt.setText("!")
                emailTxt.setTextColor(Color.RED)
                emailLayout.error = null
                isValid = false
            } else {
                emailTxt.setTextColor(Color.BLACK)
            }

            if (password.isEmpty()) {
                passwordTxt.setText("!")
                passwordTxt.setTextColor(Color.RED)
                passwordLayout.error = null
                isValid = false
            } else {
                passwordTxt.setTextColor(Color.BLACK)
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordTxt.setText("!")
                confirmPasswordTxt.setTextColor(Color.RED)
                confirmPasswordLayout.error = null
                isValid = false
            } else {
                confirmPasswordTxt.setTextColor(Color.BLACK)
            }

            if (phoneNumber.isEmpty()) {
                phoneNumberTxt.setText("!")
                phoneNumberTxt.setTextColor(Color.RED)
                isValid = false
            } else {
                phoneNumberTxt.setTextColor(Color.BLACK)
            }

            if (isValid) {
                Toast.makeText(this, "SMS yuborilmoqda...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SmsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}