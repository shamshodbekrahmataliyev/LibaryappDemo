package itcenter.dangara.libaryappdemo.loginpage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import itcenter.dangara.libaryappdemo.R
import itcenter.dangara.libaryappdemo.loginpage.SmsActivity

class RegisterActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_register)

        fullNameTxt = findViewById(R.id.fullname)
        emailTxt = findViewById(R.id.email)
        passwordTxt = findViewById(R.id.password)
        confirmPasswordTxt = findViewById(R.id.confirmpassword)
        phoneNumberTxt = findViewById(R.id.phone_number)

        fullNameLayout = findViewById(R.id.email_layout)
        emailLayout = findViewById(R.id.emaiL)
        passwordLayout = findViewById(R.id.passworD)
        confirmPasswordLayout = findViewById(R.id.confirmP)

        var back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            finish()
        }

        val sendSMSButton = findViewById<MaterialButton>(R.id.sendSMS)

        phoneNumberTxt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().startsWith("+998")) {
                    phoneNumberTxt.setText("+998")
                    phoneNumberTxt.setSelection(phoneNumberTxt.text.length)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        sendSMSButton.setOnClickListener {
            val fullName = fullNameTxt.text.toString().trim()
            val email = emailTxt.text.toString().trim()
            val password = passwordTxt.text.toString().trim()
            val confirmPassword = confirmPasswordTxt.text.toString().trim()
            val phoneNumber = phoneNumberTxt.text.toString().trim()

            var isValid = true

            if (fullName.isEmpty()) {
                fullNameTxt.error = "Required"
                isValid = false
            }

            if (email.isEmpty()) {
                emailTxt.error = "Required"
                isValid = false
            }

            if (password.isEmpty()) {
                passwordTxt.error = "Required"
                isValid = false
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordTxt.error = "Required"
                isValid = false
            }

            if (phoneNumber.length <= 4) {
                phoneNumberTxt.error = "Required"
                isValid = false
            }

            if (isValid) {
                val intent = Intent(this, SmsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}