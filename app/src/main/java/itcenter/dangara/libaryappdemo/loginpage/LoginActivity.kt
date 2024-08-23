package itcenter.dangara.libaryappdemo.loginpage

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import itcenter.dangara.libaryappdemo.R
import itcenter.dangara.libaryappdemo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var emailTxt: TextInputEditText
    private lateinit var passwordTxt: TextInputEditText
    private lateinit var emailLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailTxt = findViewById(R.id.email)
        passwordTxt = findViewById(R.id.password)
        emailLayout = findViewById(R.id.email_layout)
        passwordLayout = findViewById(R.id.password_layout)

        binding.resentPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity,PasswordRecoveryActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<MaterialButton>(R.id.login)

        loginButton.setOnClickListener {
            val email = emailTxt.text.toString().trim()
            val password = passwordTxt.text.toString().trim()

            var isValid = true

            if (email.isEmpty()) {
                emailLayout.error = "!"
                emailTxt.setTextColor(Color.RED)
                startShakingAnimation(emailLayout, emailTxt)
                isValid = false
            } else {
                emailLayout.error = null
                emailTxt.setTextColor(Color.BLACK)
            }

            if (password.isEmpty()) {
                passwordLayout.error = "!"
                passwordTxt.setTextColor(Color.RED)
                startShakingAnimation(passwordLayout, passwordTxt)
                isValid = false
            } else {
                passwordLayout.error = null
                passwordTxt.setTextColor(Color.BLACK)
            }

            if (isValid) {
                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startShakingAnimation(layout: TextInputLayout, field: TextInputEditText) {
        val rotation = PropertyValuesHolder.ofFloat("rotation", -10f, 10f, -10f)

        val layoutAnimator = ObjectAnimator.ofPropertyValuesHolder(layout, rotation)
        layoutAnimator.duration = 200
        layoutAnimator.repeatCount = 5
        layoutAnimator.repeatMode = ObjectAnimator.REVERSE
        layoutAnimator.interpolator = LinearInterpolator()

        val fieldAnimator = ObjectAnimator.ofPropertyValuesHolder(field, rotation)
        fieldAnimator.duration = 200
        fieldAnimator.repeatCount = 5
        fieldAnimator.repeatMode = ObjectAnimator.REVERSE
        fieldAnimator.interpolator = LinearInterpolator()

        layoutAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                layout.rotation = 0f
            }
            override fun onAnimationCancel(animation: Animator) {
                layout.rotation = 0f
            }
            override fun onAnimationRepeat(animation: Animator) {}
        })

        fieldAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                field.rotation = 0f
            }
            override fun onAnimationCancel(animation: Animator) {
                field.rotation = 0f
            }
            override fun onAnimationRepeat(animation: Animator) {}
        })

        layoutAnimator.start()
        fieldAnimator.start()
    }
}