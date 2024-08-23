package itcenter.dangara.libaryappdemo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.loginpage.LoginActivity

class SliderActivity : AppCompatActivity() {

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        val nextTxt: TextView = findViewById(R.id.nextTxt)
        val textTxt: TextView = findViewById(R.id.textTxt)

        nextTxt.setOnClickListener {
            clickCount++

            if (clickCount == 1) {
                textTxt.text = getString(R.string.nextTxt2)
            } else if (clickCount == 2) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}