package itcenter.dangara.libaryappdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.databinding.ActivityTilBinding
import java.util.*

class TilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        val englishLayout: LinearLayout = findViewById(R.id.English)
        val russianLayout: LinearLayout = findViewById(R.id.Russian)
        val uzbekistanLayout: LinearLayout = findViewById(R.id.Uzbekistan)

        val engCheck: ImageView = findViewById(R.id.eng_check)
        val ruCheck: ImageView = findViewById(R.id.ru_check)
        val uzbCheck: ImageView = findViewById(R.id.uzb_check)

        englishLayout.setOnClickListener {
            Log.d("TilActivity", "English selected")
            engCheck.visibility = View.VISIBLE
            ruCheck.visibility = View.GONE
            uzbCheck.visibility = View.GONE
            setLocale("en")
        }

        russianLayout.setOnClickListener {
            Log.d("TilActivity", "Russian selected")
            engCheck.visibility = View.GONE
            ruCheck.visibility = View.VISIBLE
            uzbCheck.visibility = View.GONE
            setLocale("ru")
        }

        uzbekistanLayout.setOnClickListener {
            Log.d("TilActivity", "Uzbekistan selected")
            engCheck.visibility = View.GONE
            ruCheck.visibility = View.GONE
            uzbCheck.visibility = View.VISIBLE
            setLocale("uz")
        }
    }

    private fun setLocale(languageCode: String) {
        Log.d("TilActivity", "Setting locale to $languageCode")
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Restart activity to apply language change
        val intent = intent
        finish()
        startActivity(intent)
    }
}