package itcenter.dangara.libaryappdemo

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TolovActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tolov)

        val imageView3: ImageView = findViewById(R.id.imageView3)
        val title: TextView = findViewById(R.id.title)

        // Access SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("TolovPrefs", MODE_PRIVATE)
        val hasVisitedBefore = sharedPreferences.getBoolean("hasVisitedBefore", false)

        if (hasVisitedBefore) {
            // Change imageView3 to check_button and title to tolov_qabul_qilindi
            imageView3.setImageResource(R.drawable.check_button)
            title.text = getString(R.string.tolov_qabul_qilindi)
        }

        val editor = sharedPreferences.edit()
        editor.putBoolean("hasVisitedBefore", true)
        editor.apply()
    }
}